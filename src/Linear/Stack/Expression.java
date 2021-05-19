package Linear.Stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Expression {
    private final List<Character> leftBrackets = Arrays.asList('{', '<', '[', '(');
    private final List<Character> rightBrackets = Arrays.asList('}', '>', ']', ')');
    private final Stack<Character> characterStack = new Stack<>();
    String input;

    public Expression(String input) {
        this.input = input;
    }

    public boolean isBalanced() {
        for (char ch : input.toCharArray()) {
            if (isOpeningBracket(ch))
                characterStack.push(ch);

            else if (isClosingBracket(ch)) {
                if (characterStack.empty())
                    return false;

                var top = characterStack.pop();
                if (!bracketsMatch(top, ch))
                    return false;
            }

        }
        return characterStack.empty();
    }

    private boolean isOpeningBracket(char ch) {
        return leftBrackets.contains(leftBrackets);
    }

    private boolean isClosingBracket(char ch) {
        return rightBrackets.contains(ch);
    }

    private boolean bracketsMatch(char left, char right) {
        return
                leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
    }

}
