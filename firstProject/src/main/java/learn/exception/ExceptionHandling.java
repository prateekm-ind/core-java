package learn.exception;

public class ExceptionHandling {
    public static void main(String[] args) {
        //System.out.println("RESULT: "+ testFinallyBlock());
        caseWhenFinallyBlockWillNotBeExecuted();
    }

    public static String testFinallyBlock(){
        try{
            System.out.println("inside the try-block");
            //return "from try"; //this code will never be executed
            throw new RuntimeException("runtime exception");
        }catch (Exception e){
            System.out.println("message"+ e);
            System.out.println("Inside the catch block");
            //return "from catch"; //this code also will never be executed
        }finally {
            System.out.println("Inside the finally block");
            //this will be returned every time
            return "from finally";
        }

    }

    public static void caseWhenFinallyBlockWillNotBeExecuted(){
        try{
            System.out.println("Inside the try block");
            System.exit(0);
        }catch (Exception ex){
            System.out.println("inside the catch block");
        } finally {
            System.out.println("Inside the finally block");
        }
    }
}
