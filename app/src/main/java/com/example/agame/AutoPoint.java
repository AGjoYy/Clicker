package com.example.agame;

class AutoPoint {
    static class autoPoint extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Click.i++;
                Click.tv.setText(java.lang.Integer.toString(Click.i));
            }
        }
    }
}


