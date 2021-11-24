import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

class Pair<T1, T2> {
    public T1 f;
    public T2 s;

    Pair(T1 f, T2 s) {
        this.f = f;
        this.s = s;
    }
}

class FileIsEmptyException extends Exception {
}

class IntendedLineWidthException extends Exception {
}

class InputExceedsTextMaxSize extends Exception {
}

class WidthNegativeOrZero extends Exception {
}

class InputContainsAnEmptyWord extends Exception {
}

class inputContainsForbiddenSymbol extends Exception {
    char sym;

    public inputContainsForbiddenSymbol(char sym) {
        this.sym = sym;
    }
}

class ExceedsTheLimitOfSymbols extends Exception {
    String word;

    public ExceedsTheLimitOfSymbols(String word) {
        this.word = word;
    }
}


// 1 2 3 4 5 6 7 8 9
class Main {
    public static Pair<String, Integer> getStringAndWidth() throws FileNotFoundException, FileIsEmptyException, IntendedLineWidthException, InputExceedsTextMaxSize, WidthNegativeOrZero {
        Scanner fileIn = new Scanner(new File("input.txt"));
        String inputString;
        try {
            inputString = fileIn.nextLine();
        } catch (NoSuchElementException e) {
            throw new FileIsEmptyException();
        }

        if (inputString.length() > 300) {
            throw new InputExceedsTextMaxSize();
        }

        int width;
        try {
            width = Integer.parseInt(fileIn.nextLine());
        } catch (NoSuchElementException e) {
            throw new IntendedLineWidthException();
        }

        if (width <= 0) {
            throw new WidthNegativeOrZero();
        }

        return new Pair<String, Integer>(inputString, width);
    }

    private static String[] getWords(String data) throws InputContainsAnEmptyWord, inputContainsForbiddenSymbol, ExceedsTheLimitOfSymbols {
        String[] words = data.split(" ");
        for (String x : words) {
            if (x.isEmpty()) {
                throw new InputContainsAnEmptyWord();
            }
        }
        String allowedSym = " .,!?\u00AD:;()'\"" + "abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < data.length(); i++) {
            if (allowedSym.indexOf(data.charAt(i)) == -1) {
                throw new inputContainsForbiddenSymbol(data.charAt(i));
            }
        }

        for (String word : words) {
            if (word.length() > 20) {
                throw new ExceedsTheLimitOfSymbols(word);
            }
        }

        return words;
    }

    public static void main(String[] args) throws IOException {
        // output file

        FileWriter fileWriter = new FileWriter("output.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);

        //
        String inputData = "";
        int width = 0;
        String[] words = new String[0];
        // begin of get input
        try {
            var tmp = getStringAndWidth();
            inputData = tmp.f;
            width = tmp.s;
            words = getWords(inputData);
        } catch (FileNotFoundException e) {
            printWriter.println("Exception, file not found!");
            printWriter.close();
            System.exit(0);
        } catch (FileIsEmptyException e) {
            printWriter.println("Exception, file is empty!");
            printWriter.close();
            System.exit(0);
        } catch (IntendedLineWidthException e) {
            printWriter.println("Exception, intended line width is not specified!");
            printWriter.close();
            System.exit(0);
        } catch (InputExceedsTextMaxSize e) {
            printWriter.println("Exception, input exceeds text max size!");
            printWriter.close();
            System.exit(0);
        } catch (WidthNegativeOrZero e) {
            printWriter.println("Exception, line width cannot be negative or zero!");
            printWriter.close();
            System.exit(0);
        } catch (InputContainsAnEmptyWord e) {
            printWriter.println("Exception, input contains an empty word!");
            printWriter.close();
            System.exit(0);
        } catch (inputContainsForbiddenSymbol e) {
            printWriter.printf("Exception, input contains forbidden symbol \'%c\'!", e.sym);
            printWriter.close();
            System.exit(0);
        } catch (ExceedsTheLimitOfSymbols e) {
            printWriter.printf("Exception, \'%s\' exceeds the limit of 20 symbols!", e.word);
            printWriter.close();
            System.exit(0);
        }

        for (String word : words) {
            if (word.length() > width) {
                printWriter.printf("Exception, \'%s\' exceeds %d symbols!", word, width);
                printWriter.close();
                System.exit(0);
            }
        }

        // main part starts here!
//        int DEBUG = 0;
        int indexStart = 0;
        while (indexStart < words.length) {
            int currentLength = 0, indexEnd = indexStart;
            boolean flag = false;
            while (indexEnd < words.length) {
                currentLength += words[indexEnd].length();
                if (currentLength + (indexEnd - indexStart) > width) {
                    flag = true;
                    break;
                }
                indexEnd += 1;
            }
            if (flag) {
                currentLength -= words[indexEnd].length();
            } else {
                for (int i = indexStart; i < indexEnd; i++) {
                    printWriter.print(words[i] + ' ');
//                    System.out.print(words[i] + ' ');
                }
                printWriter.close();
                System.exit(0);
            }
            indexEnd -= 1;
            int size = indexEnd - indexStart;
            if (size == 0) {
                size = 1;
            }
            int spaces[] = new int[size];
            int index = 0, colSpaces = width - currentLength;
            while (colSpaces != 0) {
                spaces[index] += 1;
                index = (index + 1) % size;
                colSpaces -= 1;
            }

            for (int i = indexStart; i <= indexEnd; i++) {
//                System.out.print(words[i]);
                printWriter.print(words[i]);
                if (i != indexEnd) {
//                    System.out.println(i);
                    for (int j = 0; j < spaces[i - indexStart]; j++) {
                        printWriter.print(" ");
//                        System.out.print(" ");
                    }
                }

            }

//            System.out.println("");
            printWriter.println("");
            indexStart = indexEnd + 1;
        }
        printWriter.close();
    }
}
