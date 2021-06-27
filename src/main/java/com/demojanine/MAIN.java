package com.demojanine;

public class MAIN {

	public static void main(String[] args) {
		MAIN movingTotal = new MAIN();

        movingTotal.append(new int[] { 1, 2, 3, 4 });

        System.out.println(movingTotal.contains(6));
        System.out.println(movingTotal.contains(9));
        System.out.println(movingTotal.contains(12));
        System.out.println(movingTotal.contains(7));

        movingTotal.append(new int[] { 5 });

        System.out.println(movingTotal.contains(6));
        System.out.println(movingTotal.contains(9));        
        System.out.println(movingTotal.contains(12));
        System.out.println(movingTotal.contains(7));

	}
	
    public void append(int[] list) {
        throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    /**
     * Returns boolean representing if any three consecutive integers in the
     * internal list have given total.
     */
    public boolean contains(int total) {
        throw new UnsupportedOperationException("Waiting to be implemented.");
    }

}
