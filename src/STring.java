import java.util.Scanner;

public class STring {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print(StringChallenge(s.nextLine()));
    }

    public static boolean StringChallenge(String str) {
        // code goes here
        String[] args = str.split(" ");
        String[] exp = args[0].split("");
        String[] stringValue = args[1].split("");
        int loops = 0;

        String currentStringValue = stringValue[0];

        for(int i=0;i<exp.length;i++){
            String e = exp[i];

            if(e.equals("+")){
                if(!currentStringValue.matches("[a-zA-Z]")){
                    return false;
                }
                if(loops+1<stringValue.length){
                    currentStringValue = stringValue[loops+1];
                    loops++;
                }

                if(loops>=stringValue.length || (exp.length-i==1 && stringValue.length-loops != exp.length-1)){
                    return false;
                }
                continue;
            }
            if(e.equals("*")){
                int repeats = 3;
                if(!currentStringValue.matches("[A-Za-z]")){
                    return false;
                }

                String repeatVal = currentStringValue;

                if(loops+1<stringValue.length){
                    currentStringValue=stringValue[loops+1];
                    loops++;
                }

                if(loops>= stringValue.length || (exp.length-i==1 && stringValue.length-loops != exp.length-i) ){
                    return false;
                }

                for(int j= 1; j<repeats;j++){
                    if(!currentStringValue.equals(repeatVal)){
                        return false;
                    }

                    if(loops+1<stringValue.length){
                        currentStringValue=stringValue[loops+1];
                        loops++;
                    }

                    if(loops>= stringValue.length || (exp.length-i==1 && stringValue.length-loops != exp.length-i) ){
                        return false;
                    }

                }
                continue;
            }
        }

        return true;
    }
    public static String SearchingChallenge(String str) {
        // code goes here
        String[] exp = str.split(" ")[0].split("");
        String args = str.split(" ")[1];

        String currentChar = str.split(" ")[1].split("")[0];
        System.out.println(currentChar+""+args);

        for(int i = 0; i<args.length(); i++){
            String currentExp = exp[i];
            System.out.println(currentExp);
            if(!currentExp.equals("+")  || !currentExp.equals("*")){
                return "-1";
            }
            if(currentExp=="+"){
                System.out.println("+");
            }
            if(currentExp=="*"){
                System.out.println("*");
            }
        }


        return str;
    }
}
