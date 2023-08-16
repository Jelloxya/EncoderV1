package EncoderDecoder;
class EncoderDecoder {
    // Define the reference table containing characters for encoding/decoding
    private static final String referenceTable = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+,-./";

    // Method to encode plain text using a given offset character
    public String encode(String plainText, char offsetChar) {
        // Find the index of the offset character in the reference table
        int offset = referenceTable.indexOf(offsetChar);
        
        // Initialize a StringBuilder to store the encoded text
        StringBuilder encodedText = new StringBuilder();
        encodedText.append(offsetChar); // Append the offset character to the encoded text
        
        // Loop through each character in the plain text
        for (char c : plainText.toCharArray()) {
            int index = referenceTable.indexOf(c); // Find the index of the character in the reference table
            if (index != -1) {
                // Calculate the shifted index after applying the offset, and ensure it wraps around
                int shiftedIndex = (index - offset + referenceTable.length()) % referenceTable.length();
                
                // Append the character from the reference table at the shifted index to the encoded text
                encodedText.append(referenceTable.charAt(shiftedIndex));
            } else {
                // If the character is not found in the reference table, append it as is
                encodedText.append(c);
            }
        }

        // Return the final encoded text
        return encodedText.toString();
    }

    // Method to decode encoded text back to plain text
    public String decode(String encodedText) {
        char offsetChar = encodedText.charAt(0); // Get the offset character from the encoded text
        int offset = referenceTable.indexOf(offsetChar); // Find the index of the offset character
        
        // Initialize a StringBuilder to store the decoded text
        StringBuilder decodedText = new StringBuilder();
        
        // Loop through each character in the encoded text (excluding the offset character)
        for (char c : encodedText.substring(1).toCharArray()) {
            int index = referenceTable.indexOf(c); // Find the index of the character in the reference table
            if (index != -1) {
                // Calculate the shifted index after applying the offset, and ensure it wraps around
                int shiftedIndex = (index + offset) % referenceTable.length();
                
                // Append the character from the reference table at the shifted index to the decoded text
                decodedText.append(referenceTable.charAt(shiftedIndex));
            } else {
                // If the character is not found in the reference table, append it as is
                decodedText.append(c);
            }
        }

        // Return the final decoded text
        return decodedText.toString();
    }

    // Method to get the reference table
    public String getReferenceTable() {
        return referenceTable;
    }
}