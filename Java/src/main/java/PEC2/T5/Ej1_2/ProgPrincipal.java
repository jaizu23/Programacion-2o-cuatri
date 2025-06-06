package main.java.PEC2.T5.Ej1_2;

public class ProgPrincipal extends javax.swing.JFrame {

    Exposicion exposicion;

    Visitante v;


    /**
     * Creates new form ProgPrincipal
     */

    public ProgPrincipal() {

        initComponents();

        exposicion = new Exposicion(10, jTextField1, jTextField2);

        for (int i = 1; i <= 60; i++) {

            v = new Visitante(i, exposicion);

            v.start();

        }

    }


    /**
     * This method is called from within the constructor to
     * <p>
     * initialize the form.
     * <p>
     * WARNING: Do NOT modify this code. The content of this method is
     * <p>
     * always regenerated by the Form Editor.
     */

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        jLabel2 = new javax.swing.JLabel();

        jTextField1 = new javax.swing.JTextField();

        jLabel3 = new javax.swing.JLabel();

        jTextField2 = new javax.swing.JTextField();

        jButton1 = new javax.swing.JButton();

        jButton2 = new javax.swing.JButton();

        jButton3 = new javax.swing.JButton();

        jButton4 = new javax.swing.JButton();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);


        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jLabel1.setForeground(new java.awt.Color(102, 0, 102));

        jLabel1.setText("Gran Exposición");


        jLabel2.setText("Cola de espera:");


        jLabel3.setText("Dentro:");


        jButton1.setText("Detener");


        jButton2.setText("Reanudar");


        jButton3.setText(" Abrir");


        jButton4.setText("Cerrar");


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());

        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(

                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

                        .addGroup(layout.createSequentialGroup()

                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

                                        .addGroup(layout.createSequentialGroup()

                                                .addGap(235, 235, 235)

                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))

                                        .addGroup(layout.createSequentialGroup()

                                                .addGap(60, 60, 60)

                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)

                                                        .addComponent(jLabel3)

                                                        .addComponent(jLabel2))

                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)

                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)

                                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)

                                                        .addGroup(layout.createSequentialGroup()

                                                                .addComponent(jButton1)

                                                                .addGap(18, 18, 18)

                                                                .addComponent(jButton2))

                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()

                                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)

                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)

                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)

                                                                        .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)

                                                                        .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))

                                                                .addGap(53, 53, 53)))))

                                .addContainerGap(41, Short.MAX_VALUE))

        );

        layout.setVerticalGroup(

                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

                        .addGroup(layout.createSequentialGroup()

                                .addGap(34, 34, 34)

                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)

                                .addGap(35, 35, 35)

                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)

                                        .addComponent(jLabel2)

                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))

                                .addGap(29, 29, 29)

                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)

                                        .addComponent(jLabel3)

                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)

                                        .addComponent(jButton3))

                                .addGap(18, 18, 18)

                                .addComponent(jButton4)

                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)

                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)

                                        .addComponent(jButton1)

                                        .addComponent(jButton2))

                                .addGap(44, 44, 44))

        );


        setSize(new java.awt.Dimension(809, 338));

        setLocationRelativeTo(null);

    }// </editor-fold>


    /**
     * @param args the command line arguments
     */

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                new ProgPrincipal().setVisible(true);

            }

        });

    }


    // Variables declaration - do not modify

    private javax.swing.JButton jButton1;

    private javax.swing.JButton jButton2;

    private javax.swing.JButton jButton3;

    private javax.swing.JButton jButton4;

    private javax.swing.JLabel jLabel1;

    private javax.swing.JLabel jLabel2;

    private javax.swing.JLabel jLabel3;

    private javax.swing.JTextField jTextField1;

    private javax.swing.JTextField jTextField2;

    // End of variables declaration

}