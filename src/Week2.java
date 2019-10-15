import java.util.Stack;

public class Week2 {

    boolean balPar(String text) {

        Stack<Character> characters = new Stack<>();


        for (int i = 0; i < text.length(); i++) {
            char next = text.charAt(i);
            char poppedChar;

            switch (next) {
                case '{':
                case '[':
                case '(':
                    characters.push(next);
                    break;
                case ')':
                    poppedChar = characters.pop();
                    if (poppedChar == '(') {
                        continue;
                    } else {
                        return false;
                    }
                case ']':
                    poppedChar = characters.pop();
                    if (poppedChar == '[') {
                        continue;
                    } else {
                        return false;
                    }
                case '}':
                    poppedChar = characters.pop();
                    if (poppedChar == '{') {
                        continue;
                    } else {
                        return false;
                    }
                default:
                    break;

            }
        }
        return characters.empty();
    }
}
