package treatment;

import tree.Node;
import tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;

public class TreatmentOfStr {

    private Tree tree;
    private int power;
    private String primaryCharacters = "*/";
    private String secondaryCharacters = "+-";
    private String thirdCharacters = "√^";

    public TreatmentOfStr(String str){
        tree = new Tree(str);
        this.createTree(tree.getRoot());
    }

    private void createTree(Node node){
        if(isInBrackets(node.getValue())){
            node.setValue(node.getValue().substring(1,node.getValue().length() - 1));
        }
        System.out.println(node.getValue());
        int numbOfBracket = 0;
        int i = 0;
        int findCharacter = 0;
        boolean findPrimary = false;
        for(char character: node.getValue().toCharArray()){
            i++;
            if (character == '('){
                numbOfBracket++;
            }
            if (character == ')'){
                numbOfBracket--;
            }
            if (numbOfBracket == 0){
                if (thirdCharacters.indexOf(character) != -1){
                    findCharacter = i;
                    break;
                }
                if((findCharacter == 0 || findPrimary) && secondaryCharacters.indexOf(character) != -1){
                    findCharacter = i;
                }
                if(findCharacter == 0 && primaryCharacters.indexOf(character) != -1){
                    findPrimary = true;
                    findCharacter = i;
                }
            }
        }
        if(findCharacter != 0){
            String firstPart = node.getValue().substring(0, findCharacter-1);
            String secondPart = node.getValue().substring(findCharacter);

            System.out.println(firstPart);
            System.out.println(node.getValue().toCharArray()[findCharacter-1]);
            System.out.println(secondPart);

            node.setLeft(new Node(firstPart));
            node.setValue(Character.toString(node.getValue().toCharArray()[findCharacter-1]));
            node.setRight(new Node(secondPart));
        }
    }

    private boolean isInBrackets(String str){
        int insideCounter = 0;
        for (char character: str.toCharArray()){
            if(character == '('){
                insideCounter++;
            }
            if(insideCounter == 0){
                return false;
            }
            if(character == ')'){
                insideCounter--;
            }
        }
        return true;
    }

    public int getResult(){
        int result = 0;

        return result;
    }
}
