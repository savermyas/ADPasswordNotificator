package saver;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class OptDialog extends JFrame {

private static final long serialVersionUID = 1L;

private JPanel mainPanel = null;  //  @jve:decl-index=0:visual-constraint="65,65"
private JLabel jLabel = null;
public JTextField domainField = null;
private JLabel jLabel1 = null;
public JTextField jTextField1 = null;
private JLabel jLabel3 = null;
private JLabel jLabel4 = null;
private JLabel jLabel2 = null;
private JLabel jLabel5 = null;
public JPasswordField jPasswordField = null;
public JTextField jTextField2 = null;
private JLabel jLabel6 = null;
public JTextField jTextField6 = null;
public JTextArea jTextArea = null;
public JCheckBox jCheckBox = null;
private JLabel jLabe8 = null;
private JLabel jLabel8 = null;
private JButton jButton = null;
private JButton jButton1 = null;
public JComboBox jComboBox = null;
private JLabel jLabel61 = null;
public JComboBox jComboBox1 = null;
public JComboBox jComboBox2 = null;
private JLabel jLabel9 = null;
public JTextField jTextField3 = null;
private JLabel jLabel101 = null;
public JTextField jTextField31 = null;
private JPanel jPanel2;
private JPanel jPanel1;
public JTextField jTextField5;
private JLabel jLabel11;
public OptDialog(){
		super("Options");
		getContentPane().add(getMainPanel());
	}

@SuppressWarnings("deprecation")
private void domainFieldFocusLost()
{
	ConfigWrapper.changeProp();
}

/**
 * This method initializes mainPanel	
 * 	
 * @return javax.swing.JPanel	
 */
private JPanel getMainPanel() {
	if (mainPanel == null) {
		GridBagConstraints gridBagConstraints61 = new GridBagConstraints();
		gridBagConstraints61.fill = GridBagConstraints.BOTH;
		gridBagConstraints61.gridy = 12;
		gridBagConstraints61.weightx = 1.0;
		gridBagConstraints61.gridwidth = 2;
		gridBagConstraints61.insets = new Insets(1, 0, 1, 0);
		gridBagConstraints61.gridx = 2;
		GridBagConstraints gridBagConstraints51 = new GridBagConstraints();
		gridBagConstraints51.gridx = 0;
		gridBagConstraints51.anchor = GridBagConstraints.EAST;
		gridBagConstraints51.fill = GridBagConstraints.BOTH;
		gridBagConstraints51.insets = new Insets(1, 0, 1, 0);
		gridBagConstraints51.gridy = 12;
		jLabel101 = new JLabel();
		jLabel101.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel101.setText("Users subj:");
		GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
		gridBagConstraints4.fill = GridBagConstraints.BOTH;
		gridBagConstraints4.gridy = 9;
		gridBagConstraints4.weightx = 1.0;
		gridBagConstraints4.gridwidth = 2;
		gridBagConstraints4.insets = new Insets(1, 0, 1, 0);
		gridBagConstraints4.gridx = 2;
		GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
		gridBagConstraints3.fill = GridBagConstraints.BOTH;
		gridBagConstraints3.gridy = 8;
		gridBagConstraints3.weightx = 1.0;
		gridBagConstraints3.gridwidth = 2;
		gridBagConstraints3.insets = new Insets(15, 0, 1, 0);
		gridBagConstraints3.gridx = 2;
		GridBagConstraints gridBagConstraints26 = new GridBagConstraints();
		gridBagConstraints26.gridx = 0;
		gridBagConstraints26.fill = GridBagConstraints.BOTH;
		gridBagConstraints26.anchor = GridBagConstraints.EAST;
		gridBagConstraints26.gridy = 9;
		GridBagConstraints gridBagConstraints18 = new GridBagConstraints();
		gridBagConstraints18.gridx = 0;
		gridBagConstraints18.fill = GridBagConstraints.BOTH;
		gridBagConstraints18.anchor = GridBagConstraints.EAST;
		gridBagConstraints18.insets = new Insets(15, 0, 0, 0);
		gridBagConstraints18.gridy = 8;
		jLabel9 = new JLabel();
		jLabel9.setText("Admin mail:");
		jLabel9.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gridBagConstraints141 = new GridBagConstraints();
		gridBagConstraints141.fill = GridBagConstraints.BOTH;
		gridBagConstraints141.gridy = 7;
		gridBagConstraints141.weightx = 1.0;
		gridBagConstraints141.gridx = 3;
		GridBagConstraints gridBagConstraints131 = new GridBagConstraints();
		gridBagConstraints131.fill = GridBagConstraints.BOTH;
		gridBagConstraints131.gridy = 7;
		gridBagConstraints131.weightx = 1.0;
		gridBagConstraints131.gridx = 2;
		GridBagConstraints gridBagConstraints25 = new GridBagConstraints();
		gridBagConstraints25.gridx = 0;
		gridBagConstraints25.fill = GridBagConstraints.BOTH;
		gridBagConstraints25.anchor = GridBagConstraints.WEST;
		gridBagConstraints25.gridy = 6;
		jLabel61 = new JLabel();
		jLabel61.setPreferredSize(new Dimension(150, 16));
		jLabel61.setHorizontalTextPosition(SwingConstants.RIGHT);
		jLabel61.setText("Check every: ");
		jLabel61.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gridBagConstraints16 = new GridBagConstraints();
		gridBagConstraints16.fill = GridBagConstraints.BOTH;
		gridBagConstraints16.gridy = 6;
		gridBagConstraints16.weightx = 1.0;
		gridBagConstraints16.insets = new Insets(1, 0, 1, 0);
		gridBagConstraints16.gridwidth = 4;
		gridBagConstraints16.gridx = 2;
		GridBagConstraints gridBagConstraints48 = new GridBagConstraints();
		gridBagConstraints48.gridx = 3;
		gridBagConstraints48.insets = new Insets(16, 0, 5, 0);
		gridBagConstraints48.fill = GridBagConstraints.NONE;
		gridBagConstraints48.gridy = 15;
		GridBagConstraints gridBagConstraints47 = new GridBagConstraints();
		gridBagConstraints47.fill = GridBagConstraints.BOTH;
		gridBagConstraints47.gridy = 10;
		gridBagConstraints47.weightx = 1.0;
		gridBagConstraints47.weighty = 1.0;
		gridBagConstraints47.insets = new Insets(1, 0, 0, 0);
		gridBagConstraints47.gridwidth = 3;
		gridBagConstraints47.gridx = 2;
		GridBagConstraints gridBagConstraints24 = new GridBagConstraints();
		gridBagConstraints24.gridx = 2;
		gridBagConstraints24.insets = new Insets(16, 0, 5, 0);
		gridBagConstraints24.fill = GridBagConstraints.NONE;
		gridBagConstraints24.gridy = 15;
		GridBagConstraints gridBagConstraints23 = new GridBagConstraints();
		gridBagConstraints23.gridx = 0;
		gridBagConstraints23.fill = GridBagConstraints.BOTH;
		gridBagConstraints23.anchor = GridBagConstraints.CENTER;
		gridBagConstraints23.insets = new Insets(1, 0, 1, 0);
		gridBagConstraints23.gridy = 13;
		jLabel8 = new JLabel();
		jLabel8.setPreferredSize(new Dimension(150, 16));
		jLabel8.setHorizontalTextPosition(SwingConstants.RIGHT);
		jLabel8.setText("User msg: ");
		jLabel8.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gridBagConstraints22 = new GridBagConstraints();
		gridBagConstraints22.gridx = 0;
		gridBagConstraints22.fill = GridBagConstraints.BOTH;
		gridBagConstraints22.anchor = GridBagConstraints.CENTER;
		gridBagConstraints22.insets = new Insets(1, 0, 1, 0);
		gridBagConstraints22.gridy = 11;
		jLabe8 = new JLabel();
		jLabe8.setPreferredSize(new Dimension(150, 16));
		jLabe8.setHorizontalTextPosition(SwingConstants.RIGHT);
		jLabe8.setText("Send to users: ");
		jLabe8.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gridBagConstraints211 = new GridBagConstraints();
		gridBagConstraints211.gridx = 0;
		gridBagConstraints211.fill = GridBagConstraints.BOTH;
		gridBagConstraints211.anchor = GridBagConstraints.CENTER;
		gridBagConstraints211.insets = new Insets(1, 0, 1, 0);
		gridBagConstraints211.gridy = 10;
		GridBagConstraints gridBagConstraints19 = new GridBagConstraints();
		gridBagConstraints19.gridx = 2;
		gridBagConstraints19.fill = GridBagConstraints.NONE;
		gridBagConstraints19.anchor = GridBagConstraints.CENTER;
		gridBagConstraints19.gridwidth = 2;
		gridBagConstraints19.gridy = 11;
		GridBagConstraints gridBagConstraints17 = new GridBagConstraints();
		gridBagConstraints17.fill = GridBagConstraints.BOTH;
		gridBagConstraints17.gridy = 13;
		gridBagConstraints17.weightx = 1.0;
		gridBagConstraints17.weighty = 1.0;
		gridBagConstraints17.anchor = GridBagConstraints.CENTER;
		gridBagConstraints17.insets = new Insets(1, 0, 1, 0);
		gridBagConstraints17.gridwidth = 5;
		gridBagConstraints17.gridx = 2;
		GridBagConstraints gridBagConstraints15 = new GridBagConstraints();
		gridBagConstraints15.fill = GridBagConstraints.BOTH;
		gridBagConstraints15.gridy = 5;
		gridBagConstraints15.weightx = 1.0;
		gridBagConstraints15.insets = new Insets(1, 0, 1, 0);
		gridBagConstraints15.gridwidth = 2;
		gridBagConstraints15.gridx = 2;
		GridBagConstraints gridBagConstraints14 = new GridBagConstraints();
		gridBagConstraints14.gridx = 0;
		gridBagConstraints14.fill = GridBagConstraints.BOTH;
		gridBagConstraints14.insets = new Insets(1, 0, 1, 0);
		gridBagConstraints14.gridy = 5;
		jLabel6 = new JLabel();
		jLabel6.setPreferredSize(new Dimension(150, 16));
		jLabel6.setHorizontalTextPosition(SwingConstants.RIGHT);
		jLabel6.setText("Base DN: ");
		jLabel6.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
		gridBagConstraints13.fill = GridBagConstraints.BOTH;
		gridBagConstraints13.gridy = 3;
		gridBagConstraints13.weightx = 1.0;
		gridBagConstraints13.insets = new Insets(1, 0, 1, 0);
		gridBagConstraints13.gridwidth = 2;
		gridBagConstraints13.gridx = 2;
		GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
		gridBagConstraints12.fill = GridBagConstraints.BOTH;
		gridBagConstraints12.gridy = 4;
		gridBagConstraints12.weightx = 1.0;
		gridBagConstraints12.insets = new Insets(1, 0, 1, 0);
		gridBagConstraints12.gridwidth = 2;
		gridBagConstraints12.gridx = 2;
		GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
		gridBagConstraints11.gridx = 0;
		gridBagConstraints11.fill = GridBagConstraints.BOTH;
		gridBagConstraints11.anchor = GridBagConstraints.CENTER;
		gridBagConstraints11.insets = new Insets(1, 0, 1, 0);
		gridBagConstraints11.gridy = 4;
		jLabel5 = new JLabel();
		jLabel5.setPreferredSize(new Dimension(150, 16));
		jLabel5.setHorizontalTextPosition(SwingConstants.RIGHT);
		jLabel5.setText("Password: ");
		jLabel5.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
		gridBagConstraints7.gridx = 0;
		gridBagConstraints7.fill = GridBagConstraints.BOTH;
		gridBagConstraints7.anchor = GridBagConstraints.CENTER;
		gridBagConstraints7.insets = new Insets(1, 0, 1, 0);
		gridBagConstraints7.gridy = 3;
		jLabel2 = new JLabel();
		jLabel2.setPreferredSize(new Dimension(150, 16));
		jLabel2.setHorizontalTextPosition(SwingConstants.RIGHT);
		jLabel2.setText("Username: ");
		jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
		gridBagConstraints6.gridx = 2;
		gridBagConstraints6.insets = new Insets(5, 0, 5, 0);
		gridBagConstraints6.fill = GridBagConstraints.BOTH;
		gridBagConstraints6.anchor = GridBagConstraints.CENTER;
		gridBagConstraints6.gridy = 0;
		jLabel4 = new JLabel();
		jLabel4.setText("Value");
		jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel4.setVerticalAlignment(SwingConstants.BOTTOM);
		jLabel4.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
		gridBagConstraints5.gridx = 0;
		gridBagConstraints5.insets = new Insets(5, 0, 5, 0);
		gridBagConstraints5.fill = GridBagConstraints.BOTH;
		gridBagConstraints5.anchor = GridBagConstraints.CENTER;
		gridBagConstraints5.gridy = 0;
		jLabel3 = new JLabel();
		jLabel3.setText("Parameter");
		jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel3.setVerticalAlignment(SwingConstants.BOTTOM);
		jLabel3.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
		gridBagConstraints21.fill = GridBagConstraints.BOTH;
		gridBagConstraints21.gridy = 2;
		gridBagConstraints21.weightx = 1.0;
		gridBagConstraints21.gridwidth = 3;
		gridBagConstraints21.anchor = GridBagConstraints.CENTER;
		gridBagConstraints21.insets = new Insets(1, 0, 1, 0);
		gridBagConstraints21.gridx = 2;
		GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
		gridBagConstraints2.gridx = 0;
		gridBagConstraints2.fill = GridBagConstraints.BOTH;
		gridBagConstraints2.anchor = GridBagConstraints.CENTER;
		gridBagConstraints2.insets = new Insets(1, 0, 1, 0);
		gridBagConstraints2.gridy = 2;
		jLabel1 = new JLabel();
		jLabel1.setText("Domain controler: ");
		jLabel1.setHorizontalTextPosition(SwingConstants.RIGHT);
		jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel1.setPreferredSize(new Dimension(150, 16));
		GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
		gridBagConstraints1.fill = GridBagConstraints.BOTH;
		gridBagConstraints1.gridy = 1;
		gridBagConstraints1.weightx = 1.0;
		gridBagConstraints1.insets = new Insets(1, 0, 1, 0);
		gridBagConstraints1.gridwidth = 3;
		gridBagConstraints1.anchor = GridBagConstraints.CENTER;
		gridBagConstraints12.anchor = GridBagConstraints.CENTER;
		gridBagConstraints13.anchor = GridBagConstraints.CENTER;
		gridBagConstraints14.anchor = GridBagConstraints.CENTER;
		gridBagConstraints15.anchor = GridBagConstraints.CENTER;
		gridBagConstraints1.gridx = 2;
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.anchor = GridBagConstraints.CENTER;
		gridBagConstraints.insets = new Insets(1, 0, 1, 0);
		gridBagConstraints.gridy = 1;
		jLabel = new JLabel();
		jLabel.setText("Domain: ");
		jLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
		jLabel.setPreferredSize(new Dimension(150, 16));
		jLabel.setVerticalAlignment(SwingConstants.CENTER);
	mainPanel = new JPanel();
	GridBagLayout mainPanelLayout = new GridBagLayout();
		mainPanel.setLayout(mainPanelLayout);
		mainPanelLayout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1};
		mainPanelLayout.columnWidths = new int[] {7, 7, 7, 7};
		mainPanelLayout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
		mainPanelLayout.rowHeights = new int[] {7, 7, 7, 7, 7, 7, 20, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7};
		mainPanel.setSize(new Dimension(421, 518));
		mainPanel.setPreferredSize(new java.awt.Dimension(626, 497));
		mainPanel.add(jLabel, gridBagConstraints);
		mainPanel.add(getJTextField(), new GridBagConstraints(2, 1, 2, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 0, 1, 0), 0, 0));
		mainPanel.add(jLabel1, gridBagConstraints2);
		mainPanel.add(getJTextField1(), new GridBagConstraints(2, 2, 2, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 0, 1, 0), 0, 0));
		mainPanel.add(jLabel3, gridBagConstraints5);
		mainPanel.add(jLabel4, gridBagConstraints6);
		mainPanel.add(jLabel2, gridBagConstraints7);
		mainPanel.add(jLabel5, gridBagConstraints11);
		mainPanel.add(getJPasswordField(), new GridBagConstraints(2, 4, 2, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 0, 1, 0), 0, 0));
		mainPanel.add(getJTextField2(), new GridBagConstraints(2, 3, 2, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 0, 1, 0), 0, 0));
		mainPanel.add(jLabel6, gridBagConstraints14);
		mainPanel.add(getJTextField6(), new GridBagConstraints(2, 5, 2, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 0, 1, 0), 0, 0));
		mainPanel.add(getJTextArea(), new GridBagConstraints(2, 14, 2, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 0, 1, 0), 0, 0));
		mainPanel.add(getJCheckBox(), new GridBagConstraints(2, 12, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		mainPanel.add(jLabe8, new GridBagConstraints(0, 12, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 0, 1, 0), 0, 0));
		mainPanel.add(jLabel8, new GridBagConstraints(0, 14, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 0, 1, 0), 0, 0));
		mainPanel.add(getJButton(), new GridBagConstraints(2, 16, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(16, 0, 5, 0), 0, 0));
		mainPanel.add(getJButton1(), new GridBagConstraints(3, 16, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(16, 0, 5, 0), 0, 0));
		mainPanel.add(getJComboBox(), new GridBagConstraints(2, 7, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 0, 1, 0), 0, 0));
		mainPanel.add(jLabel61, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		mainPanel.add(getJComboBox1(), new GridBagConstraints(2, 8, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		mainPanel.add(getJComboBox2(), new GridBagConstraints(3, 8, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		mainPanel.add(jLabel9, new GridBagConstraints(0, 9, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(15, 0, 0, 0), 0, 0));
		mainPanel.add(getJTextField3(), new GridBagConstraints(2, 9, 2, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(15, 0, 1, 0), 0, 0));
		mainPanel.add(jLabel101, new GridBagConstraints(0, 13, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(1, 0, 1, 0), 0, 0));
		mainPanel.add(getJTextField31(), new GridBagConstraints(2, 13, 2, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 0, 1, 0), 0, 0));
		mainPanel.add(getJLabel11(), new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		mainPanel.add(getJTextField5(), new GridBagConstraints(2, 6, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
		mainPanel.add(getJPanel1(), new GridBagConstraints(2, 15, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		mainPanel.add(getJPanel2(), new GridBagConstraints(3, 15, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
	}
	return mainPanel;
}

/**
 * This method initializes domainField	
 * 	
 * @return javax.swing.JTextField	
 * 
 */
private JTextField getJTextField() {
	if (domainField == null) {
		domainField = new JTextField();
		domainField.setText(ConfigWrapper.prop.getProperty("domain"));
		domainField.setPreferredSize(new Dimension(200, 20));
		domainField.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusLost(java.awt.event.FocusEvent e) {
				//System.out.println("focusLost()"); // TODO Auto-generated Event stub focusLost()
				domainFieldFocusLost();
			}
		});
	}
	return domainField;
}

/**
 * This method initializes jTextField1	
 * 	
 * @return javax.swing.JTextField	
 */
private JTextField getJTextField1() {
	if (jTextField1 == null) {
		jTextField1 = new JTextField();
		jTextField1.setText(ConfigWrapper.prop.getProperty("domaincontroler"));
		jTextField1.setPreferredSize(new Dimension(200, 20));
		jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusLost(java.awt.event.FocusEvent e) {
				//System.out.println("focusLost()"); // TODO Auto-generated Event stub focusLost()
				domainFieldFocusLost();
			}
		});
	}
	return jTextField1;
}

/**
 * This method initializes jPasswordField	
 * 	
 * @return javax.swing.JPasswordField	
 */
private JPasswordField getJPasswordField() {
	if (jPasswordField == null) {
		jPasswordField = new JPasswordField();
		jPasswordField.setPreferredSize(new Dimension(200, 20));
		jPasswordField.setText(ConfigWrapper.prop.getProperty("password"));

		jPasswordField.addFocusListener(new java.awt.event.FocusAdapter() {
			
			public void focusLost(java.awt.event.FocusEvent e) {
				//System.out.println("focusLost()"); // 
				domainFieldFocusLost();
			}
		});
	}
	return jPasswordField;
}

/**
 * This method initializes jTextField2	
 * 	
 * @return javax.swing.JTextField	
 */
private JTextField getJTextField2() {
	if (jTextField2 == null) {
		jTextField2 = new JTextField();
		jTextField2.setText(ConfigWrapper.prop.getProperty("username"));
		jTextField2.setPreferredSize(new Dimension(200, 20));
		jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusLost(java.awt.event.FocusEvent e) {
				//System.out.println("focusLost()"); // TODO Auto-generated Event stub focusLost()
				domainFieldFocusLost();
			}
		});
	}
	return jTextField2;
}

/**
 * This method initializes jTextField6	
 * 	
 * @return javax.swing.JTextField	
 */
private JTextField getJTextField6() {
	if (jTextField6 == null) {
		jTextField6 = new JTextField();
		jTextField6.setPreferredSize(new Dimension(200, 20));
		jTextField6.setText(ConfigWrapper.prop.getProperty("basedn"));
		jTextField6.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusLost(java.awt.event.FocusEvent e) {
				//System.out.println("focusLost()"); // TODO Auto-generated Event stub focusLost()
				domainFieldFocusLost();
			}
		});
	}
	return jTextField6;
}

/**
 * This method initializes jTextArea	
 * 	
 * @return javax.swing.JTextArea	
 */
private JTextArea getJTextArea() {
	if (jTextArea == null) {
		jTextArea = new JTextArea();
		jTextArea.setText(ConfigWrapper.prop.getProperty("usertext"));
		jTextArea.setLineWrap(true);
		jTextArea.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusLost(java.awt.event.FocusEvent e) {
				//System.out.println("focusLost()"); // TODO Auto-generated Event stub focusLost()
				domainFieldFocusLost();			
			}
		});
		jTextArea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	}
	return jTextArea;
}

/**
 * This method initializes jCheckBox	
 * 	
 * @return javax.swing.JCheckBox	
 */
private JCheckBox getJCheckBox() {
	if (jCheckBox == null) {
		jCheckBox = new JCheckBox();
		jCheckBox.setSelected(Boolean.valueOf((String)ConfigWrapper.prop.setProperty("sendtousers",jTextArea.getText())));
		jCheckBox.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusLost(java.awt.event.FocusEvent e) {
				//System.out.println("focusLost()"); // TODO Auto-generated Event stub focusLost()
				domainFieldFocusLost();
			}
		});
	}
	return jCheckBox;
}

/**
 * This method initializes jButton	
 * 	
 * @return javax.swing.JButton	
 */
private JButton getJButton() {
	if (jButton == null) {
		jButton = new JButton();
		jButton.setText("Run now!");
		jButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				MainTray.s.startSearch();
			}
		});
	}
	return jButton;
}

/**
 * This method initializes jButton1	
 * 	
 * @return javax.swing.JButton	
 */
private JButton getJButton1() {
	if (jButton1 == null) {
		jButton1 = new JButton();
		jButton1.setText("Save");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				///System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				//ConfigWrapper.prop.save(arg0, arg1);
				ConfigWrapper.saveProp();
			}
		});
	}
	return jButton1;
}

/**
 * This method initializes jComboBox	
 * 	
 * @return javax.swing.JComboBox	
 */
private JComboBox getJComboBox() {
	if (jComboBox == null) {
		jComboBox = new JComboBox(new String[]{"week", "day", "hour"});
		jComboBox.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent evt) {
				//System.out.println("jComboBox.focusLost, event="+evt);
				//TODO add your code for jComboBox.focusLost
				domainFieldFocusLost();
			}
		});
		jComboBox.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(java.awt.event.ActionEvent e) {
				//System.out.println("actionPerformed() " + jComboBox.getSelectedIndex()); // TODO Auto-generated Event stub actionPerformed()
				switch (jComboBox.getSelectedIndex())
				{
				case 2: {jComboBox1.hide(); jComboBox2.hide();break;}
				case 1: {jComboBox1.show(); jComboBox2.hide();break;}
				case 0: {jComboBox1.show(); jComboBox2.show(); break;}
				}
				mainPanel.revalidate();
				
			
			}
			
		});
		
	}  
	return jComboBox;
}

/**
 * This method initializes jComboBox1	
 * 	
 * @return javax.swing.JComboBox	
 */
private JComboBox getJComboBox1() {
	String[] times = new String[]{"00:00", "01:00", "02:00", "03:00", "04:00", "05:00", 
			"06:00", "07:00", "08:00", "09:00", "10:00", "11:00", 
			"12:00", "13:00", "14:00", "15:00", "16:00", "17:00",
			"18:00", "19:00", "20:00", "21:00", "22:00", "23:00"};
	int i = 0;
	for(int j = 0; j<times.length; j++)
	{
		if(times[j].equals(ConfigWrapper.prop.getProperty("time")))
			i = j;
	}
	if (jComboBox1 == null) {
		jComboBox1 = new JComboBox(times);
		jComboBox1.setVisible(true);
//		jComboBox1.setSelectedIndex(5);
		jComboBox1.setSelectedIndex(i);
		jComboBox1.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusLost(java.awt.event.FocusEvent e) {
				//System.out.println("focusLost()"); // TODO Auto-generated Event stub focusLost()
				domainFieldFocusLost();
			}
		});
	}
	return jComboBox1;
}

/**
 * This method initializes jComboBox2	
 * 	
 * @return javax.swing.JComboBox	
 */
private JComboBox getJComboBox2() {
	if (jComboBox2 == null) {
		jComboBox2 = new JComboBox(new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"});
		jComboBox2.setVisible(true);
		jComboBox2.setSelectedIndex(Integer.valueOf(ConfigWrapper.prop.getProperty("dayofweek"))-1);
		//Integer.valueOf(arg0)
		jComboBox2.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusLost(java.awt.event.FocusEvent e) {
				//System.out.println("focusLost()"); // TODO Auto-generated Event stub focusLost()
				domainFieldFocusLost();				
			}
		});
	}
	return jComboBox2;
}

/**
 * This method initializes jTextField3	
 * 	
 * @return javax.swing.JTextField	
 */
private JTextField getJTextField3() {
	if (jTextField3 == null) {
		jTextField3 = new JTextField();
		jTextField3.setText(ConfigWrapper.prop.getProperty("postmaster"));
		jTextField3.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusLost(java.awt.event.FocusEvent e) {
				//System.out.println("focusLost()"); // TODO Auto-generated Event stub focusLost()
				domainFieldFocusLost();
			}
		});
	}
	return jTextField3;
}

/**
 * This method initializes jTextField31	
 * 	
 * @return javax.swing.JTextField	
 */
private JTextField getJTextField31() {
	if (jTextField31 == null) {
		jTextField31 = new JTextField();
		jTextField31.setText(ConfigWrapper.prop.getProperty("clientsubject"));
		jTextField31.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusLost(java.awt.event.FocusEvent e) {
				//System.out.println("focusLost()"); // TODO Auto-generated Event stub focusLost()
				domainFieldFocusLost();
			}
		});
	}
	return jTextField31;
}	

private JLabel getJLabel11() {
	if(jLabel11 == null) {
		jLabel11 = new JLabel();
		jLabel11.setText("Days before expiration: ");
		jLabel11.setHorizontalAlignment(SwingConstants.RIGHT);
		jLabel11.setHorizontalTextPosition(SwingConstants.RIGHT);
		jLabel11.setPreferredSize(new Dimension(150,16));
	}
	return jLabel11;
}

private JTextField getJTextField5() {
	if(jTextField5 == null) {
		jTextField5 = new JTextField();
		jTextField5.setPreferredSize(new Dimension(200,20));
		jTextField5.setText(ConfigWrapper.prop.getProperty("expire"));
		jTextField5.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent evt) {
				domainFieldFocusLost();
			}
		});
	}
	return jTextField5;
}

private void jTextField5FocusLost(FocusEvent evt) {
	System.out.println("jTextField5.focusLost, event="+evt);
	//TODO add your code for jTextField5.focusLost
}

private JPanel getJPanel1() {
	if(jPanel1 == null) {
		jPanel1 = new JPanel();
	}
	return jPanel1;
}

private JPanel getJPanel2() {
	if(jPanel2 == null) {
		jPanel2 = new JPanel();
	}
	return jPanel2;
}

}
