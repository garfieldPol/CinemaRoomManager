class FixingExceptions {

    public static void calculateSquare(int[] array, int index) {
        // write your code here
         int number = 0;

        if (index < 0 || index > array.length - 1 || array == null) {
            System.out.println("Exception!");

            try {
                for (int i = 0; i < array.length; i++) {
                   number =  array[i];
                }
            } catch (NullPointerException e) {
                System.out.println("Exception!");
            }
        }


        else {System.out.println(array[index] * array[index]);}






//        boolean correct = true;
//
//         if(correct) {
//             while (correct) {
//
//                 if (index > 0 || index <= array.length - 1 || array == null) {
//                     System.out.println("Exception!");
//                     correct = false;
//                 }
//
//                 try {
//                     calculateSquare(array, index);
//                 } catch (ArrayIndexOutOfBoundsException e) {
//                     System.out.println("Exception!");
//                     correct = false;
//                 }
//
//
//
//             }
//         } else {
//             System.out.println(array[index] * array[index]);
//             correct = false;
//         }

    }
}