package com.company;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;



public  class CodingText implements Constants {


    static public void codding(String filePath, int key) {
        try {
            byte[] buf = Files.readAllBytes(Paths.get(filePath));
            for (int i = 0; i < buf.length; ++i) {
                if (CheckLetter.result(buf[i]) != NOT_LETTER)
                    buf[i] += key;
            }

            int p = filePath.lastIndexOf(".");
            String newFilePath = filePath.substring(0, p) + "_Code" + filePath.substring(p);
            Files.write(Paths.get(newFilePath), buf);
        } catch (Exception exc) {
            System.out.print(exc.toString());
        }


    }

    static public BufferedReader encodding(String filePath, int key) {
        try {
            byte[] buf = Files.readAllBytes(Paths.get(filePath));

            for (int i = 0; i < buf.length; ++i) {
                if (CheckLetter.result(buf[i] - key) != NOT_LETTER)
                    buf[i] -= key;
            }

            return new BufferedReader(new InputStreamReader(new ByteArrayInputStream(buf)));

           /* int p = filePath.lastIndexOf(".");
            String newFilePath = filePath.substring(0, p) + "_Code" + filePath.substring(p);
            Files.write(Paths.get(newFilePath), buf);*/
        } catch (Exception exc) {
            System.out.print(exc.toString());
            return null;
        }
    }

    static public ByteArrayInputStream encodding(ByteArrayInputStream bais, int key) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int b;
            while ((b = bais.read()) != -1) {
                b -= key;
                baos.write(b);
            }
            byte[] byteAr = baos.toByteArray();

            return new ByteArrayInputStream(byteAr);

        } catch (Exception exc) {
            System.out.print(exc.toString());
            return null;
        }
    }

    static private byte[] encodding(byte[] inpByte, int key) {
        try {
            byte[] outBytes = new byte[inpByte.length];
            System.arraycopy(inpByte, 0, outBytes, 0, inpByte.length);

            for (int i = 0; i < outBytes.length; ++i) {
                if (CheckLetter.result(outBytes[i] - key) != NOT_LETTER)
                    outBytes[i] -= key;
            }

            return outBytes;

        } catch (Exception exc) {
            System.out.print(exc.toString());
            return null;
        }
    }

    static public void encoddingFile(String filePath) {
        try {
            byte[] buf1 = Files.readAllBytes(Paths.get(filePath));
            byte[] buf2;


            double[] freqBuf1 = new FreqLetters(buf1).get();
            double[] freqBuf2;


            for (int key = 1; key < 12; ++key) {
                buf2 = encodding(buf1, key);
                freqBuf2 = new FreqLetters(buf2).get();
                if (Comparer.getPrecission(freqBuf1) > Comparer.getPrecission(freqBuf2)) {
                    buf1 = buf2;
                    freqBuf1 = freqBuf2;
                }
            }

            int p = filePath.lastIndexOf(".");
            String newFilePath = filePath.substring(0, p) + "_Encode" + filePath.substring(p);
            Files.write(Paths.get(newFilePath), buf1);

        } catch (Exception exc) {
            System.out.print(exc.toString());
        }
    }
}
