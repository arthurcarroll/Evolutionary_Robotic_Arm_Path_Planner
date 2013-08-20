package fattaco.dyndns.org.evo_path_planner;

import RobotModel.SimulationConfiguration;
import main.Driver;
import java.awt.Component;
import java.io.File;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * RobotView.java
 *
 * Created on Apr 23, 2011, 9:55:40 PM
 */
/**
 *
 * @author arthur
 */
public class RobotView extends javax.swing.JFrame {

    SimulationConfigController controller = new SimulationConfigController();
    Driver d;

    /** Creates new form RobotView
     * @param d The driver to report to
     */
    public RobotView(Driver d) {
        this.d = d;
        initComponents();
        controller.syncronizeListModels(this);
        this.isSphereObstacle.setEnabled(false);
        this.randomObstaclesCheckBox.setEnabled(false);
    }

    public JTextField getMaxMutAmountTextField() {
        return maxMutAmountTextField;
    }

    public JTextField getMutProbTextField() {
        return mutProbTextField;
    }

    public JTextField getPopSizeTextField() {
        return popSizeTextField;
    }

    public SimulationConfiguration getConfig() {
        return controller.getSimConfig();
    }

    public JCheckBox getRandomKnotPointsCheckBox() {
        return randomKnotPointsCheckBox;
    }

    public void setRandomKnotPointsCheckBox(JCheckBox randomKnotPointsCheckBox) {
        this.randomKnotPointsCheckBox = randomKnotPointsCheckBox;
    }

    public JComboBox getEditJointVariableChoice() {
        return editJointVariableChoice;
    }

    public JComboBox getJointVariableChoice() {
        return jointVariableChoice;
    }

    public JTextField getAddAP() {
        return addAP;
    }

    public JCheckBox getUseWorstPathCheckBox() {
        return useWorstPathCheckBox;
    }

    public void setUseWorstPathCheckBox(JCheckBox useWorstPathCheckBox) {
        this.useWorstPathCheckBox = useWorstPathCheckBox;
    }

    public JTextField getAddAlphaP() {
        return addAlphaP;
    }

    public JTextField getAddDi() {
        return addDi;
    }

    public JTextField getAddJointVariableGoalPosition() {
        return addJointVariableGoalPosition;
    }

    public JTextField getAddJointVariableStartPosition() {
        return addJointVariableStartPosition;
    }

    public JTextField getAddThetai() {
        return addThetai;
    }

    public JTextField getEditAP() {
        return editAP;
    }

    public JTextField getEditAlphaP() {
        return editAlphaP;
    }

    public JTextField getEditDi() {
        return editDi;
    }

    public JTextField getEditJointVariableGoalPosition() {
        return editJointVariableGoalPosition;
    }

    public JTextField getKnotPointsTextField() {
        return knotPointsTextField;
    }

    public void setKnotPointsTextField(JTextField knotPointsTextField) {
        this.knotPointsTextField = knotPointsTextField;
    }

    public JTextField getCollisionWeightTextField() {
        return collisionWeightTextField;
    }

    public void setCollisionWeightTextField(JTextField collisionWeightTextField) {
        this.collisionWeightTextField = collisionWeightTextField;
    }

    public JTextField getEditJointVariableStartPosition() {
        return editJointVariableStartPosition;
    }

    public JTextField getMoveWeightTextField() {
        return moveWeightTextField;
    }

    public void setMoveWeightTextField(JTextField moveWeightTextField) {
        this.moveWeightTextField = moveWeightTextField;
    }

    public JTextField getStuckTimesTextField() {
        return stuckTimesTextField;
    }

    public void setStuckTimesTextField(JTextField stuckTimesTextField) {
        this.stuckTimesTextField = stuckTimesTextField;
    }

    public JTextField getEditThetai() {
        return editThetai;
    }

    public JList getJointList() {
        return jointList;
    }

    public JList getJointVariablesList() {
        return jointVariablesList;
    }

    public JList getObstaclesList() {
        return obstaclesList;
    }

    public JTextField getxEditObstaclePos() {
        return xEditObstaclePos;
    }

    public JTextField getxEditObstacleRot() {
        return xEditObstacleRot;
    }

    public JTextField getxEditObstacleSize() {
        return xEditObstacleSize;
    }

    public JTextField getyEditObstaclePos() {
        return yEditObstaclePos;
    }

    public JTextField getyEditObstacleRot() {
        return yEditObstacleRot;
    }

    public JTextField getyEditObstacleSize() {
        return yEditObstacleSize;
    }

    public JTextField getzEditObstaclePos() {
        return zEditObstaclePos;
    }

    public JTextField getzEditObstacleRot() {
        return zEditObstacleRot;
    }

    public JTextField getzEditObstacleSize() {
        return zEditObstacleSize;
    }

    public JTextField getxObstaclePos() {
        return xObstaclePos;
    }

    public JTextField getxObstacleRot() {
        return xObstacleRot;
    }

    public JTextField getxObstacleSize() {
        return xObstacleSize;
    }

    public JTextField getyObstaclePos() {
        return yObstaclePos;
    }

    public JTextField getyObstacleRot() {
        return yObstacleRot;
    }

    public JTextField getyObstacleSize() {
        return yObstacleSize;
    }

    public JTextField getzObstaclePos() {
        return zObstaclePos;
    }

    public JTextField getzObstacleRot() {
        return zObstacleRot;
    }

    public JTextField getzObstacleSize() {
        return zObstacleSize;
    }

    public JCheckBox getIsSphereObstacle() {
        return isSphereObstacle;
    }

    public JTextField getEditObstacleType() {
        return editObstacleType;
    }

    public void disableAllChildren(JPanel jp, boolean enabled) {
        jp.setEnabled(enabled);
        for (Component c : jp.getComponents()) {
            c.setEnabled(enabled);
            //c.setVisible(enabled);

        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jointList = new javax.swing.JList();
        jointListLabel = new javax.swing.JLabel();
        deleteJointButton = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        addAP = new javax.swing.JTextField();
        addDi = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        addThetai = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        addNewJointButton = new javax.swing.JButton();
        addAlphaP = new javax.swing.JTextField();
        addNewJointLabel = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        editAP = new javax.swing.JTextField();
        editDi = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        editThetai = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        updateJointButton = new javax.swing.JButton();
        editAlphaP = new javax.swing.JTextField();
        editJointLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        addJointVariableStartPosition = new javax.swing.JTextField();
        addNewJointVariableButton = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        addJointVariableGoalPosition = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jointVariableChoice = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jointVariablesList = new javax.swing.JList();
        obstacleLable1 = new javax.swing.JLabel();
        deleteJointVariableButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        editJointVariableStartPosition = new javax.swing.JTextField();
        editJointVariableButton = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        editJointVariableGoalPosition = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        editJointVariableChoice = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        addSquareObstaclePanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        xObstacleRot = new javax.swing.JTextField();
        yObstacleRot = new javax.swing.JTextField();
        zObstacleRot = new javax.swing.JTextField();
        xObstacleSize = new javax.swing.JTextField();
        yObstacleSize = new javax.swing.JTextField();
        zObstacleSize = new javax.swing.JTextField();
        xObstaclePos = new javax.swing.JTextField();
        yObstaclePos = new javax.swing.JTextField();
        zObstaclePos = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        addSquareObstacleButton = new javax.swing.JButton();
        isSphereObstacle = new javax.swing.JCheckBox();
        obstacleListPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        obstaclesList = new javax.swing.JList();
        obstacleLable = new javax.swing.JLabel();
        removeObstacleButton = new javax.swing.JButton();
        editObstaclePanel = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        editObstacleType = new javax.swing.JTextField();
        yEditObstacleRot = new javax.swing.JTextField();
        zEditObstacleRot = new javax.swing.JTextField();
        xEditObstacleSize = new javax.swing.JTextField();
        yEditObstacleSize = new javax.swing.JTextField();
        zEditObstacleSize = new javax.swing.JTextField();
        xEditObstaclePos = new javax.swing.JTextField();
        yEditObstaclePos = new javax.swing.JTextField();
        zEditObstaclePos = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        updateObstacleButton = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        xEditObstacleRot = new javax.swing.JTextField();
        randomObstaclesCheckBox = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        maxMutAmountTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        mutProbTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        popSizeTextField = new javax.swing.JTextField();
        setEvoConfigButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        moveWeightTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        collisionWeightTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        stuckTimesTextField = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        knotPointsTextField = new javax.swing.JTextField();
        randomKnotPointsCheckBox = new javax.swing.JCheckBox();
        useWorstPathCheckBox = new javax.swing.JCheckBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenu = new javax.swing.JMenuItem();
        saveMenu = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Robot Configuration Tool");
        setAlwaysOnTop(true);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jointList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jointList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jointListMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jointList);

        jointListLabel.setText("Joints");

        deleteJointButton.setText("Delete");
        deleteJointButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteJointButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jointListLabel)
                        .addContainerGap(280, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(deleteJointButton)
                        .addGap(163, 163, 163))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jointListLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(deleteJointButton)
                .addContainerGap())
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel38.setText("d i");

        jLabel39.setText("a i-1");

        jLabel40.setText("alpha i-1");

        jLabel41.setText("theta i");

        addNewJointButton.setText("Add -->");
        addNewJointButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addNewJointButtonMouseClicked(evt);
            }
        });

        addNewJointLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addNewJointLabel.setText("Add New Joint");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addAlphaP, 0, 0, Short.MAX_VALUE)
                            .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39)
                            .addComponent(addAP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel38)
                            .addComponent(addDi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(addThetai, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                                .addComponent(addNewJointButton))
                            .addComponent(jLabel41)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(addNewJointLabel)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(addNewJointLabel)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel39)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addAP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addDi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addThetai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addAlphaP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(addNewJointButton)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel38)
                                .addComponent(jLabel41))
                            .addGap(35, 35, 35))))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel42.setText("d i");

        jLabel43.setText("a i-1");

        jLabel44.setText("alpha i-1");

        jLabel45.setText("theta i");

        updateJointButton.setText("Update");
        updateJointButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateJointButtonMouseClicked(evt);
            }
        });

        editJointLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        editJointLabel.setText("Edit Joint");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(editAlphaP, 0, 0, Short.MAX_VALUE)
                            .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel43)
                            .addComponent(editAP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel42)
                            .addComponent(editDi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(editThetai, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                                .addComponent(updateJointButton))
                            .addComponent(jLabel45)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(editJointLabel)))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(editJointLabel)
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editAP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editDi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editThetai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updateJointButton)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editAlphaP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel42)
                        .addComponent(jLabel45)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(277, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Link Parameters", jPanel1);

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel21.setText("Name");

        jLabel22.setText("Start");

        addNewJointVariableButton.setText("Add -->");
        addNewJointVariableButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addNewJointVariableButtonMouseClicked(evt);
            }
        });

        jLabel23.setText("Goal");

        jLabel5.setText("Add new Variable");

        jointVariableChoice.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Theta i", "di" }));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel21)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel23)))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addJointVariableGoalPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(addJointVariableStartPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(addNewJointVariableButton))))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jointVariableChoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jointVariableChoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(addJointVariableStartPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addNewJointVariableButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(addJointVariableGoalPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jointVariablesList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jointVariablesList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jointVariablesListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jointVariablesList);

        obstacleLable1.setText("Joint Variables");

        deleteJointVariableButton.setText("Delete");
        deleteJointVariableButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteJointVariableButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                            .addComponent(obstacleLable1)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(deleteJointVariableButton)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(obstacleLable1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(deleteJointVariableButton)
                .addContainerGap())
        );

        jLabel1.setText("!!! The number of joint variables must match the number of joints in Robot Config  !!!");

        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel27.setText("Name");

        jLabel28.setText("Start");

        editJointVariableButton.setText("Update");
        editJointVariableButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editJointVariableButtonMouseClicked(evt);
            }
        });

        jLabel29.setText("Goal");

        jLabel30.setText("Edit Variable");

        editJointVariableChoice.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Theta i", "di" }));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel27)))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel29)))
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(editJointVariableGoalPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(editJointVariableStartPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40)
                                        .addComponent(editJointVariableButton))))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(editJointVariableChoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel30)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(editJointVariableChoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(editJointVariableStartPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editJointVariableButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(editJointVariableGoalPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Start/Goal", jPanel2);

        addSquareObstaclePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Add new Obstacle");

        jLabel10.setText("Position");

        jLabel11.setText("Size");

        jLabel12.setText("Rotation");

        jLabel13.setText("X");

        jLabel14.setText("Y");

        jLabel15.setText("Z");

        addSquareObstacleButton.setText("Add -->");
        addSquareObstacleButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addSquareObstacleButtonMouseClicked(evt);
            }
        });

        isSphereObstacle.setText("Sphere");

        javax.swing.GroupLayout addSquareObstaclePanelLayout = new javax.swing.GroupLayout(addSquareObstaclePanel);
        addSquareObstaclePanel.setLayout(addSquareObstaclePanelLayout);
        addSquareObstaclePanelLayout.setHorizontalGroup(
            addSquareObstaclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addSquareObstaclePanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(addSquareObstaclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(addSquareObstaclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(addSquareObstaclePanelLayout.createSequentialGroup()
                        .addComponent(xObstacleRot, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(yObstacleRot, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(zObstacleRot, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addSquareObstaclePanelLayout.createSequentialGroup()
                        .addComponent(xObstacleSize, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(yObstacleSize, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(zObstacleSize, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                        .addComponent(addSquareObstacleButton))
                    .addGroup(addSquareObstaclePanelLayout.createSequentialGroup()
                        .addGroup(addSquareObstaclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(xObstaclePos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(addSquareObstaclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(yObstaclePos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(addSquareObstaclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addSquareObstaclePanelLayout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(76, 76, 76)
                                .addComponent(isSphereObstacle))
                            .addComponent(zObstaclePos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)))
                .addContainerGap())
        );
        addSquareObstaclePanelLayout.setVerticalGroup(
            addSquareObstaclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addSquareObstaclePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(15, 15, 15)
                .addGroup(addSquareObstaclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(isSphereObstacle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addSquareObstaclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(xObstaclePos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yObstaclePos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zObstaclePos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(addSquareObstaclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(xObstacleSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yObstacleSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zObstacleSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addSquareObstacleButton))
                .addGap(19, 19, 19)
                .addGroup(addSquareObstaclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(xObstacleRot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yObstacleRot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zObstacleRot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        obstacleListPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        obstaclesList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        obstaclesList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                obstaclesListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(obstaclesList);

        obstacleLable.setText("Obstacles");

        removeObstacleButton.setText("Remove");
        removeObstacleButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeObstacleButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout obstacleListPanelLayout = new javax.swing.GroupLayout(obstacleListPanel);
        obstacleListPanel.setLayout(obstacleListPanelLayout);
        obstacleListPanelLayout.setHorizontalGroup(
            obstacleListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(obstacleListPanelLayout.createSequentialGroup()
                .addGroup(obstacleListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(obstacleListPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
                    .addGroup(obstacleListPanelLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(obstacleLable))
                    .addGroup(obstacleListPanelLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(removeObstacleButton)))
                .addContainerGap())
        );
        obstacleListPanelLayout.setVerticalGroup(
            obstacleListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(obstacleListPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(obstacleLable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addGap(13, 13, 13)
                .addComponent(removeObstacleButton)
                .addContainerGap())
        );

        editObstaclePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel16.setText("Edit Obstacle");

        jLabel17.setText("Position");

        jLabel18.setText("Size");

        jLabel19.setText("Rotation");

        jLabel20.setText("X");

        jLabel24.setText("Y");

        jLabel25.setText("Z");

        updateObstacleButton.setText("Update");
        updateObstacleButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateObstacleButtonMouseClicked(evt);
            }
        });

        jLabel26.setText("Type");

        javax.swing.GroupLayout editObstaclePanelLayout = new javax.swing.GroupLayout(editObstaclePanel);
        editObstaclePanel.setLayout(editObstaclePanelLayout);
        editObstaclePanelLayout.setHorizontalGroup(
            editObstaclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editObstaclePanelLayout.createSequentialGroup()
                .addGroup(editObstaclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editObstaclePanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(editObstaclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)))
                    .addGroup(editObstaclePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel26)))
                .addGap(18, 18, 18)
                .addGroup(editObstaclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editObstaclePanelLayout.createSequentialGroup()
                        .addComponent(xEditObstacleRot, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(yEditObstacleRot, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(zEditObstacleRot, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(editObstaclePanelLayout.createSequentialGroup()
                        .addGroup(editObstaclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(xEditObstaclePos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addGap(18, 18, 18)
                        .addGroup(editObstaclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(yEditObstaclePos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))
                        .addGap(18, 18, 18)
                        .addGroup(editObstaclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(zEditObstaclePos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(editObstacleType, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(editObstaclePanelLayout.createSequentialGroup()
                        .addGroup(editObstaclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16)
                            .addGroup(editObstaclePanelLayout.createSequentialGroup()
                                .addComponent(xEditObstacleSize, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(yEditObstacleSize, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(zEditObstacleSize, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateObstacleButton)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        editObstaclePanelLayout.setVerticalGroup(
            editObstaclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editObstaclePanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editObstaclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel20)
                    .addComponent(jLabel25))
                .addGap(18, 18, 18)
                .addGroup(editObstaclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(xEditObstaclePos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yEditObstaclePos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zEditObstaclePos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(editObstaclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(xEditObstacleSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yEditObstacleSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zEditObstacleSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateObstacleButton))
                .addGap(19, 19, 19)
                .addGroup(editObstaclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(yEditObstacleRot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zEditObstacleRot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xEditObstacleRot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editObstaclePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(editObstacleType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        randomObstaclesCheckBox.setText("Random Obstacles");
        randomObstaclesCheckBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                randomObstaclesCheckBoxMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addSquareObstaclePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(obstacleListPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editObstaclePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(randomObstaclesCheckBox)))
                .addGap(63, 63, 63))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(randomObstaclesCheckBox)
                .addGap(46, 46, 46)
                .addComponent(editObstaclePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(obstacleListPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(addSquareObstaclePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(162, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Obstacles", jPanel3);

        jLabel2.setText("Max Mutation Ammount");

        maxMutAmountTextField.setText("3");

        jLabel3.setText("Mutation Probability (0.1 - 1)");

        mutProbTextField.setText("0.5");

        jLabel4.setText("Population Size (max RAM)");

        popSizeTextField.setText("10");

        setEvoConfigButton.setText("Set Values");
        setEvoConfigButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                setEvoConfigButtonMouseClicked(evt);
            }
        });

        jLabel6.setText("Move Weight");

        moveWeightTextField.setText("1");

        jLabel7.setText("Collision Weight");

        collisionWeightTextField.setText("10");

        jLabel8.setText("Stuck Times");

        stuckTimesTextField.setText("10");

        jLabel31.setText("Knot Configurations");

        knotPointsTextField.setText("4");

        randomKnotPointsCheckBox.setText("Random Knots");
        randomKnotPointsCheckBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                randomKnotPointsCheckBoxMouseClicked(evt);
            }
        });

        useWorstPathCheckBox.setText("Use worst path");
        useWorstPathCheckBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                useWorstPathCheckBoxMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(stuckTimesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(collisionWeightTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(popSizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(moveWeightTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(knotPointsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(maxMutAmountTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                                    .addComponent(mutProbTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(setEvoConfigButton))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(randomKnotPointsCheckBox)
                                    .addComponent(useWorstPathCheckBox))))
                        .addGap(478, 478, 478))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(maxMutAmountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(mutProbTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(popSizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(setEvoConfigButton))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(moveWeightTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(collisionWeightTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(stuckTimesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(randomKnotPointsCheckBox)
                        .addGap(18, 18, 18)
                        .addComponent(useWorstPathCheckBox)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addComponent(knotPointsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(147, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Evo Sim", jPanel6);

        fileMenu.setText("File");
        fileMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fileMenuMouseClicked(evt);
            }
        });

        openMenu.setText("Open");
        openMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openMenuMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                openMenuMousePressed(evt);
            }
        });
        fileMenu.add(openMenu);

        saveMenu.setText("Save");
        saveMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveMenuMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                saveMenuMousePressed(evt);
            }
        });
        fileMenu.add(saveMenu);

        jMenuBar1.add(fileMenu);

        jMenu3.setText("Simulation");

        jMenuItem4.setText("Run");
        jMenuItem4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem4MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem4MousePressed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1058, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     *
     * callbacks
     * @param evt
     */
    private void addNewJointButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addNewJointButtonMouseClicked
        controller.addNewJointButtonCallback(this);
    }//GEN-LAST:event_addNewJointButtonMouseClicked

    private void updateJointButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateJointButtonMouseClicked
        controller.updateJointButtonCallback(this);
    }//GEN-LAST:event_updateJointButtonMouseClicked

    private void deleteJointButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteJointButtonMouseClicked
        controller.deleteJointButtonCallback(this);
    }//GEN-LAST:event_deleteJointButtonMouseClicked

    private void jointListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jointListMouseClicked
        controller.jointListCallback(this);
    }//GEN-LAST:event_jointListMouseClicked

    private void randomObstaclesCheckBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_randomObstaclesCheckBoxMouseClicked
/*        controller.setRandomGoals(randomObstaclesCheckBox.isSelected());

        disableAllChildren(addSquareObstaclePanel, !randomObstaclesCheckBox.isSelected());
        disableAllChildren(editObstaclePanel, !randomObstaclesCheckBox.isSelected());
        disableAllChildren(obstacleListPanel, !randomObstaclesCheckBox.isSelected());

        this.validate();*/
    }//GEN-LAST:event_randomObstaclesCheckBoxMouseClicked

    private void openMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openMenuMouseClicked
        openMenuMousePressed(evt);
    }//GEN-LAST:event_openMenuMouseClicked

    private void saveMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMenuMouseClicked
        saveMenuMousePressed(evt);
    }//GEN-LAST:event_saveMenuMouseClicked

    private void fileMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fileMenuMouseClicked
        // do nothing
    }//GEN-LAST:event_fileMenuMouseClicked

    private void saveMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMenuMousePressed

        String filename = File.separator + "tmp";
        JFileChooser fc = new JFileChooser(new File("../"));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("xml", "xml");
        fc.setFileFilter(filter);
        // Show save dialog; this method does not return until the dialog is closed
        fc.showSaveDialog(this);
        File selFile = fc.getSelectedFile();
        if (selFile != null) {
            controller.saveButtonClicked(this, selFile.getPath());
        }
    }//GEN-LAST:event_saveMenuMousePressed

    private void openMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openMenuMousePressed
        String filename = File.separator + "tmp";
        JFileChooser fc = new JFileChooser(new File("../"));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("xml", "xml");
        fc.setFileFilter(filter);
        // Show save dialog; this method does not return until the dialog is closed
        fc.showOpenDialog(this);
        File selFile = fc.getSelectedFile();
        if (selFile != null) {
            controller.openButtonClicked(this, selFile.getPath());
        }
    }//GEN-LAST:event_openMenuMousePressed

    private void addNewJointVariableButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addNewJointVariableButtonMouseClicked
        controller.addJointVariableButtonCallback(this);
    }//GEN-LAST:event_addNewJointVariableButtonMouseClicked

    private void jointVariablesListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jointVariablesListMouseClicked
        controller.jointVariableListCallback(this);
    }//GEN-LAST:event_jointVariablesListMouseClicked

    private void deleteJointVariableButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteJointVariableButtonMouseClicked
        controller.deleteJointVariableCallback(this);
    }//GEN-LAST:event_deleteJointVariableButtonMouseClicked

    private void editJointVariableButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editJointVariableButtonMouseClicked
        controller.updateJointVariableCallback(this);
    }//GEN-LAST:event_editJointVariableButtonMouseClicked

    private void addSquareObstacleButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addSquareObstacleButtonMouseClicked
        controller.addNewObstacleButtonCallback(this);
    }//GEN-LAST:event_addSquareObstacleButtonMouseClicked

    private void obstaclesListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_obstaclesListMouseClicked
        controller.obstacleListCallback(this);
    }//GEN-LAST:event_obstaclesListMouseClicked

    private void removeObstacleButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeObstacleButtonMouseClicked
        controller.deleteObstacleButtonCallback(this);
    }//GEN-LAST:event_removeObstacleButtonMouseClicked

    private void updateObstacleButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateObstacleButtonMouseClicked
        controller.updateObstacleButtonCallback(this);
    }//GEN-LAST:event_updateObstacleButtonMouseClicked

    private void jMenuItem4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem4MouseClicked
        d.runSimulation(controller.getSimConfig());
    }//GEN-LAST:event_jMenuItem4MouseClicked

    private void jMenuItem4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem4MousePressed
        jMenuItem4MouseClicked(evt);
    }//GEN-LAST:event_jMenuItem4MousePressed

    private void setEvoConfigButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_setEvoConfigButtonMouseClicked
        controller.setEvoValues(this, controller.getSimConfig());
    }//GEN-LAST:event_setEvoConfigButtonMouseClicked

    private void randomKnotPointsCheckBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_randomKnotPointsCheckBoxMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_randomKnotPointsCheckBoxMouseClicked

    private void useWorstPathCheckBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_useWorstPathCheckBoxMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_useWorstPathCheckBoxMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new RobotView(new Driver()).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addAP;
    private javax.swing.JTextField addAlphaP;
    private javax.swing.JTextField addDi;
    private javax.swing.JTextField addJointVariableGoalPosition;
    private javax.swing.JTextField addJointVariableStartPosition;
    private javax.swing.JButton addNewJointButton;
    private javax.swing.JLabel addNewJointLabel;
    private javax.swing.JButton addNewJointVariableButton;
    private javax.swing.JButton addSquareObstacleButton;
    private javax.swing.JPanel addSquareObstaclePanel;
    private javax.swing.JTextField addThetai;
    private javax.swing.JTextField collisionWeightTextField;
    private javax.swing.JButton deleteJointButton;
    private javax.swing.JButton deleteJointVariableButton;
    private javax.swing.JTextField editAP;
    private javax.swing.JTextField editAlphaP;
    private javax.swing.JTextField editDi;
    private javax.swing.JLabel editJointLabel;
    private javax.swing.JButton editJointVariableButton;
    private javax.swing.JComboBox editJointVariableChoice;
    private javax.swing.JTextField editJointVariableGoalPosition;
    private javax.swing.JTextField editJointVariableStartPosition;
    private javax.swing.JPanel editObstaclePanel;
    private javax.swing.JTextField editObstacleType;
    private javax.swing.JTextField editThetai;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JCheckBox isSphereObstacle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JList jointList;
    private javax.swing.JLabel jointListLabel;
    private javax.swing.JComboBox jointVariableChoice;
    private javax.swing.JList jointVariablesList;
    private javax.swing.JTextField knotPointsTextField;
    private javax.swing.JTextField maxMutAmountTextField;
    private javax.swing.JTextField moveWeightTextField;
    private javax.swing.JTextField mutProbTextField;
    private javax.swing.JLabel obstacleLable;
    private javax.swing.JLabel obstacleLable1;
    private javax.swing.JPanel obstacleListPanel;
    private javax.swing.JList obstaclesList;
    private javax.swing.JMenuItem openMenu;
    private javax.swing.JTextField popSizeTextField;
    private javax.swing.JCheckBox randomKnotPointsCheckBox;
    private javax.swing.JCheckBox randomObstaclesCheckBox;
    private javax.swing.JButton removeObstacleButton;
    private javax.swing.JMenuItem saveMenu;
    private javax.swing.JButton setEvoConfigButton;
    private javax.swing.JTextField stuckTimesTextField;
    private javax.swing.JButton updateJointButton;
    private javax.swing.JButton updateObstacleButton;
    private javax.swing.JCheckBox useWorstPathCheckBox;
    private javax.swing.JTextField xEditObstaclePos;
    private javax.swing.JTextField xEditObstacleRot;
    private javax.swing.JTextField xEditObstacleSize;
    private javax.swing.JTextField xObstaclePos;
    private javax.swing.JTextField xObstacleRot;
    private javax.swing.JTextField xObstacleSize;
    private javax.swing.JTextField yEditObstaclePos;
    private javax.swing.JTextField yEditObstacleRot;
    private javax.swing.JTextField yEditObstacleSize;
    private javax.swing.JTextField yObstaclePos;
    private javax.swing.JTextField yObstacleRot;
    private javax.swing.JTextField yObstacleSize;
    private javax.swing.JTextField zEditObstaclePos;
    private javax.swing.JTextField zEditObstacleRot;
    private javax.swing.JTextField zEditObstacleSize;
    private javax.swing.JTextField zObstaclePos;
    private javax.swing.JTextField zObstacleRot;
    private javax.swing.JTextField zObstacleSize;
    // End of variables declaration//GEN-END:variables
}
