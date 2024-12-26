package org.example.week13;

public class Task3 {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        // Set and use UpperCaseFormatter
        editor.setFormatter(new UpperCaseFormatter());
        System.out.println(editor.formatText("hello world"));

        // Set and use LowerCaseFormatter
        editor.setFormatter(new LowerCaseFormatter());
        System.out.println(editor.formatText("Hello World"));

        // Set and use CamelCaseFormatter
        editor.setFormatter(new CamelCaseFormatter());
        System.out.println(editor.formatText("hello world from strategy pattern"));

    }
}

interface TextFormatter {
    String formatText(String text);
}

class UpperCaseFormatter implements TextFormatter{
    @Override
    public String formatText(String text){
        return text.toUpperCase();
    }
}

class LowerCaseFormatter implements TextFormatter{
    @Override
    public String formatText(String text){
        return text.toLowerCase();
    }
}

class CamelCaseFormatter implements TextFormatter{
    @Override
    public String formatText(String text){
        StringBuilder camelCaseText = new StringBuilder();
        boolean nextUpperText = true;
        for(char c : text.toCharArray()){
            if(Character.isWhitespace(c)){
                nextUpperText = true;
            } else if (nextUpperText) {
                camelCaseText.append(Character.toUpperCase(c));
                nextUpperText = false;
            } else {
                camelCaseText.append(Character.toLowerCase(c));
            }
        }
        return camelCaseText.toString();
    }
}

class TextEditor{
    private TextFormatter formatter;

    public void setFormatter(TextFormatter formatter){
        this.formatter = formatter;
    }

    public String formatText(String text){
        if(formatter == null){
            throw new IllegalStateException("is not set");
        }
        return formatter.formatText(text);
    }
}

