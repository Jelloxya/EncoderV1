package EncoderDecoder;

public class Main {
    public static void main(String[] args) {
        EncoderDecoder encoderDecoder = new EncoderDecoder();

        String plainText = "HELLO WORLD";
        char offsetChar1 = 'B'; // Desired offset character for the first encoded text
        char offsetChar2 = 'F'; // Desired offset character for the second encoded text

        String encodedText1 = encoderDecoder.encode(plainText, offsetChar1);
        String encodedText2 = encoderDecoder.encode(plainText, offsetChar2);

        String decodedText1 = encoderDecoder.decode(encodedText1);
        String decodedText2 = encoderDecoder.decode(encodedText2);

        System.out.println("Encoded Text with offset B: " + encodedText1);
        System.out.println("Encoded Text with offset F: " + encodedText2);
        System.out.println("Decoded Text with offset B: " + decodedText1);
        System.out.println("Decoded Text with offset F: " + decodedText2);
        
        /*// Print opposite shifted reference table for offset B (1st letter shift to the back)
        System.out.println("Shifted Reference Table for offset B:");
        int offset = encoderDecoder.getReferenceTable().indexOf(offsetChar1);
        String shiftedReferenceTable = encoderDecoder.getReferenceTable().indexOf(offsetChar2);
        shiftedReferenceTable = encoderDecoder.getReferenceTable().substring(offset)
        System.out.println(shiftedReferenceTable); */
        
        // Print opposite shifted reference table for offset B
        System.out.println("Shifted Reference Table for offset B:");
        int offset = encoderDecoder.getReferenceTable().indexOf(offsetChar1);
        String shiftedReferenceTable = encoderDecoder.getReferenceTable().substring(encoderDecoder.getReferenceTable().length() - offset)
            + encoderDecoder.getReferenceTable().substring(0, encoderDecoder.getReferenceTable().length() - offset);
        System.out.println(shiftedReferenceTable);
        
        
        /*// Print shifted reference table for offset F ( 1st letter shift to the back)
        System.out.println("Shifted Reference Table for offset F:");
        offset = encoderDecoder.getReferenceTable().indexOf(offsetChar2);
        shiftedReferenceTable = encoderDecoder.getReferenceTable().substring(offset)
            + encoderDecoder.getReferenceTable().substring(0, offset);
        System.out.println(shiftedReferenceTable);*/
        
        // Print shifted reference table for offset F ( last letter shift to the front)
        System.out.println("Shifted Reference Table for offset F:");
        // Get the index of the offset character 'F' in the reference table
        offset = encoderDecoder.getReferenceTable().indexOf(offsetChar2);
        // Calculate the substring of the reference table that corresponds to the shifted part (opposite direction)
        // by taking characters from (reference table length - offset) to the end and appending characters from
        // the beginning to (reference table length - offset)
        String shiftedReferenceTableF = encoderDecoder.getReferenceTable().substring(encoderDecoder.getReferenceTable().length() - offset)
                + encoderDecoder.getReferenceTable().substring(0, encoderDecoder.getReferenceTable().length() - offset);
        System.out.println(shiftedReferenceTableF);
    }
}