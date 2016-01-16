/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qkd;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author waltersquires
 */
public class DensityListRepresentation extends javax.swing.JPanel {
    private String name;
    private DensityList data;

    /**
     * Creates new form densityListRepresentation
     */
    
    //From scratch
    public DensityListRepresentation() {
        initComponents();
        data = new DensityList();
        name = data.getName();
        updateAlice(data.getAlice());
    }
    //From existing
     public DensityListRepresentation(DensityList temp) {
        initComponents();
        data = temp;
        name = data.getName();
        updateAlice(data.getAlice());
    }

    public void updateAlice(Alice model)
    {
        DefaultTableModel newModel = (new DefaultTableModel(
            new Object [][] {
          
            },
            new String [] {
                "Wire", "Probability"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        for(Wire tempWire:model.getWires())
        {
            Object[] tempData = {tempWire.getName(),tempWire.getProbability()};
            newModel.addRow(tempData);
           
          //System.out.println(tempWire.getName());
          //javax.swing.JLabel tempLabel = new javax.swing.JLabel();
          //tempLabel.setText(tempWire.getName());
          //wires.add(tempLabel);
           // wires.ad
          //  wires.add(tempWire);
          //wireNames.append(tempWire.getName()+"\n");
        }
        wires.setModel(newModel);
    }
    
    public boolean updateProbs()
    {
        float sum =0;
        int rows = wires.getRowCount();
        for(int i = 0; i <rows; i++)
        {
        sum += (float)wires.getModel().getValueAt(i, 1);
        data.getAlice().setProb((String)wires.getModel().getValueAt(i, 0),(float)wires.getModel().getValueAt(i, 1)); 
        }
        if (sum==1)
            return true;
        else
            return false;
    }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        repAlice = new javax.swing.JPanel();
        aliceLabel = new javax.swing.JLabel();
        aliceContent = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        wires = new javax.swing.JTable();
        repEve = new javax.swing.JPanel();
        eveLabel = new javax.swing.JLabel();
        repBob = new javax.swing.JPanel();
        bobLabel = new javax.swing.JLabel();

        repAlice.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        repAlice.setLayout(new javax.swing.BoxLayout(repAlice, javax.swing.BoxLayout.Y_AXIS));

        aliceLabel.setText("Alice");
        repAlice.add(aliceLabel);

        aliceContent.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        aliceContent.setLayout(new javax.swing.BoxLayout(aliceContent, javax.swing.BoxLayout.LINE_AXIS));

        wires.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Wire", "Probability"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(wires);
        if (wires.getColumnModel().getColumnCount() > 0) {
            wires.getColumnModel().getColumn(0).setResizable(false);
            wires.getColumnModel().getColumn(1).setResizable(false);
        }

        aliceContent.add(jScrollPane2);

        repAlice.add(aliceContent);

        repEve.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        eveLabel.setText("Eve");

        javax.swing.GroupLayout repEveLayout = new javax.swing.GroupLayout(repEve);
        repEve.setLayout(repEveLayout);
        repEveLayout.setHorizontalGroup(
            repEveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(repEveLayout.createSequentialGroup()
                .addComponent(eveLabel)
                .addGap(0, 55, Short.MAX_VALUE))
        );
        repEveLayout.setVerticalGroup(
            repEveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(repEveLayout.createSequentialGroup()
                .addComponent(eveLabel)
                .addGap(0, 84, Short.MAX_VALUE))
        );

        repBob.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        bobLabel.setText("Bob");

        javax.swing.GroupLayout repBobLayout = new javax.swing.GroupLayout(repBob);
        repBob.setLayout(repBobLayout);
        repBobLayout.setHorizontalGroup(
            repBobLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(repBobLayout.createSequentialGroup()
                .addComponent(bobLabel)
                .addGap(0, 55, Short.MAX_VALUE))
        );
        repBobLayout.setVerticalGroup(
            repBobLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(repBobLayout.createSequentialGroup()
                .addComponent(bobLabel)
                .addGap(0, 84, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(repAlice, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130)
                .addComponent(repEve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(repBob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(repBob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(repEve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(repAlice, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(130, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel aliceContent;
    private javax.swing.JLabel aliceLabel;
    private javax.swing.JLabel bobLabel;
    private javax.swing.JLabel eveLabel;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel repAlice;
    private javax.swing.JPanel repBob;
    private javax.swing.JPanel repEve;
    private javax.swing.JTable wires;
    // End of variables declaration//GEN-END:variables
}
