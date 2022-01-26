/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Fungsi.fungsi;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.nio.charset.CharsetDecoder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.DatatypeConverter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author User
 */
public class lihat_petugas extends javax.swing.JFrame {
    public Statement st;
    public ResultSet rs;
    public ResultSet rs2;
    public DefaultTableModel tabmodel;
    String sql;
    Connection con = koneksi.koneksi.getKoneksi(); 
    
    /**
     * Creates new form 
     */
    public lihat_petugas() {
        initComponents();
        judul();
        tampildata();
        laki.setActionCommand("Laki-laki");
        perempuan.setActionCommand("Perempuan");
        petugas_id.setEditable(false);
        ubah.setEnabled(false);
        hapus.setEnabled(false);
        autokode();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation(
        (screenSize.width - frameSize.width) / 2,
        (screenSize.height - frameSize.height) / 2);
    }
    
    public void reset(){
        nama_petugas.setText(null);
        pass_petugas.setText(null);
        pass_konfir.setText(null);
        ambil_kelamin.clearSelection();
        telp_petugas.setText(null);
        alamat_petugas.setText(null);
        tambah.setEnabled(true);
        hapus.setEnabled(false);
        ubah.setEnabled(false);
    }
    
    public Boolean kosong(){
        return (petugas_id.getText().equals("") || nama_petugas.getText().equals("") || pass_petugas.getText().equals("") || pass_konfir.getText().equals("") || (ambil_kelamin.getSelection()==null) || telp_petugas.getText().equals("") || alamat_petugas.getText().equals(""));
    }
    
     public Boolean tidak_sesuai(){
        String pass1 = pass_petugas.getText();
        String pass2 = pass_konfir.getText();
        return !(pass1.equals(pass2));
    }
    
    public void autokode(){
         try{
            String sql;
            sql = "SELECT COUNT(id_petugas) as jumlah FROM petugas";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                String jumlah = rs.getString("jumlah");
                int jumint = Integer.parseInt(String.valueOf(jumlah));
                if (jumint > 0) {
                    st = con.createStatement();
                        sql = "SELECT MAX(id_petugas) AS kode FROM petugas";
                        rs2 = st.executeQuery(sql);
                        if(rs2.next()){
                            String id = rs2.getString("kode").substring(4);
                            String kode = String.valueOf(Integer.parseInt(id) + 1);
                            if(kode.length() == 1){
                               petugas_id.setText("PTGS0"+kode);
                            }else
                                petugas_id.setText("PTGS"+kode);
                        }
                }else{
                    petugas_id.setText("PTGS01");
                }
            }
        }catch(SQLException e){
            
        }
    }
    
    public void judul(){
        Object[] judul = {"ID Petugas","Nama Petugas","Password","Jenis Kelamin","Telepon","Alamat"};
        tabmodel = new DefaultTableModel(null,judul){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        tabel_petugas.setModel(tabmodel);
    }
    
    public void tampildata(){
        try{
            st = con.createStatement();
            tabmodel.getDataVector().removeAllElements();
            tabmodel.fireTableDataChanged();
            rs = st.executeQuery("SELECT * FROM petugas");
            while(rs.next()){
                Object [] data = {
                    rs.getString("id_petugas"),
                    rs.getString("nama"),
                    rs.getString("password"),
                    rs.getString("jk_petugas"),
                    rs.getString("telp_petugas"),
                    rs.getString("alamat_petugas"),
                };
                tabmodel.addRow(data);
                tabmodel.getRowCount();
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ambil_kelamin = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        close = new javax.swing.JButton();
        cari = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        cetak = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        logout1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_petugas = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        petugas_id = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        nama_petugas = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        telp_petugas = new javax.swing.JTextField();
        jSeparator11 = new javax.swing.JSeparator();
        tambah = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        ubah = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        alamat_petugas = new javax.swing.JTextField();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        pass_petugas = new javax.swing.JPasswordField();
        pass_konfir = new javax.swing.JPasswordField();
        laki = new javax.swing.JRadioButton();
        perempuan = new javax.swing.JRadioButton();
        jLabel22 = new javax.swing.JLabel();
        reset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(31, 70, 112));

        jLabel1.setFont(new java.awt.Font("EngraversGothic BT", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/round-account-button-with-user-inside (1)_1.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("EngraversGothic BT", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("halaman data petugas");

        close.setBackground(new java.awt.Color(28, 42, 57));
        close.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        close.setForeground(new java.awt.Color(255, 255, 255));
        close.setText("x");
        close.setToolTipText("Tutup");
        close.setBorder(null);
        close.setBorderPainted(false);
        close.setContentAreaFilled(false);
        close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close.setFocusPainted(false);
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });

        cari.setBackground(new java.awt.Color(31, 70, 112));
        cari.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        cari.setForeground(new java.awt.Color(255, 255, 255));
        cari.setBorder(null);
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });
        cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cariKeyReleased(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(240, 240, 240));

        jLabel19.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/magnifying-glass.png"))); // NOI18N

        cetak.setBackground(new java.awt.Color(31, 70, 112));
        cetak.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        cetak.setForeground(new java.awt.Color(255, 255, 255));
        cetak.setText("Cetak");
        cetak.setBorder(null);
        cetak.setContentAreaFilled(false);
        cetak.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cetak.setOpaque(true);
        cetak.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cetakMouseEntered(evt);
            }
        });
        cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("EngraversGothic BT", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Perpus SMANSAGAS");

        logout1.setBackground(new java.awt.Color(28, 42, 57));
        logout1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        logout1.setForeground(new java.awt.Color(255, 255, 255));
        logout1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/home (2).png"))); // NOI18N
        logout1.setText("Home");
        logout1.setToolTipText("Home");
        logout1.setBorder(null);
        logout1.setBorderPainted(false);
        logout1.setContentAreaFilled(false);
        logout1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logout1.setFocusPainted(false);
        logout1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 361, Short.MAX_VALUE)
                        .addComponent(logout1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cetak, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logout1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cetak, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, 120));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tabel_petugas.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        tabel_petugas.setForeground(new java.awt.Color(28, 42, 57));
        tabel_petugas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel_petugas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabel_petugas.setFocusable(false);
        tabel_petugas.setGridColor(new java.awt.Color(28, 42, 57));
        tabel_petugas.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabel_petugas.setRowHeight(25);
        tabel_petugas.setSelectionBackground(new java.awt.Color(28, 42, 57));
        tabel_petugas.setShowVerticalLines(false);
        tabel_petugas.getTableHeader().setReorderingAllowed(false);
        tabel_petugas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_petugasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_petugas);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(28, 42, 57));
        jLabel13.setText("ID Petugas");
        jPanel7.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        petugas_id.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        petugas_id.setForeground(new java.awt.Color(28, 42, 57));
        petugas_id.setBorder(null);
        jPanel7.add(petugas_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 36, 370, -1));

        jSeparator6.setForeground(new java.awt.Color(28, 42, 57));
        jPanel7.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 59, 390, 10));

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(28, 42, 57));
        jLabel14.setText("Nama");
        jPanel7.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 75, -1, -1));

        nama_petugas.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        nama_petugas.setForeground(new java.awt.Color(28, 42, 57));
        nama_petugas.setBorder(null);
        jPanel7.add(nama_petugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 370, -1));

        jSeparator7.setForeground(new java.awt.Color(28, 42, 57));
        jPanel7.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 123, 394, 10));

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(28, 42, 57));
        jLabel15.setText("Password");
        jPanel7.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 139, -1, -1));

        jSeparator8.setForeground(new java.awt.Color(28, 42, 57));
        jPanel7.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 184, 394, 10));

        jLabel16.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(28, 42, 57));
        jLabel16.setText("Konfirmasi Password");
        jPanel7.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jSeparator9.setForeground(new java.awt.Color(28, 42, 57));
        jPanel7.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 390, 10));

        jLabel17.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(28, 42, 57));
        jLabel17.setText("Jenis Kelamin");
        jPanel7.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        jLabel18.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(28, 42, 57));
        jLabel18.setText("Telepon");
        jPanel7.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        telp_petugas.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        telp_petugas.setForeground(new java.awt.Color(28, 42, 57));
        telp_petugas.setBorder(null);
        telp_petugas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telp_petugasKeyTyped(evt);
            }
        });
        jPanel7.add(telp_petugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 370, -1));

        jSeparator11.setForeground(new java.awt.Color(28, 42, 57));
        jPanel7.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 390, 10));

        tambah.setBackground(new java.awt.Color(15, 37, 62));
        tambah.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tambah.setForeground(new java.awt.Color(255, 255, 255));
        tambah.setText("Tambah");
        tambah.setBorder(null);
        tambah.setContentAreaFilled(false);
        tambah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tambah.setOpaque(true);
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });
        jPanel7.add(tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 473, 92, 37));

        hapus.setBackground(new java.awt.Color(15, 37, 62));
        hapus.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        hapus.setForeground(new java.awt.Color(255, 255, 255));
        hapus.setText("Hapus");
        hapus.setBorder(null);
        hapus.setContentAreaFilled(false);
        hapus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hapus.setOpaque(true);
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });
        jPanel7.add(hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 473, 92, 37));

        ubah.setBackground(new java.awt.Color(15, 37, 62));
        ubah.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        ubah.setForeground(new java.awt.Color(255, 255, 255));
        ubah.setText("Ubah");
        ubah.setBorder(null);
        ubah.setContentAreaFilled(false);
        ubah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ubah.setOpaque(true);
        ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahActionPerformed(evt);
            }
        });
        jPanel7.add(ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 473, 92, 37));

        jLabel20.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(28, 42, 57));
        jLabel20.setText("Alamat");
        jPanel7.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, -1, -1));

        alamat_petugas.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        alamat_petugas.setForeground(new java.awt.Color(28, 42, 57));
        alamat_petugas.setBorder(null);
        alamat_petugas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                alamat_petugasKeyTyped(evt);
            }
        });
        jPanel7.add(alamat_petugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 370, -1));

        jSeparator12.setForeground(new java.awt.Color(28, 42, 57));
        jPanel7.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 390, 10));

        jLabel21.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 0, 0));
        jLabel21.setText("* Maksimal 13 karakter");
        jPanel7.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 140, 30));

        pass_petugas.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        pass_petugas.setForeground(new java.awt.Color(28, 42, 57));
        pass_petugas.setBorder(null);
        pass_petugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pass_petugasActionPerformed(evt);
            }
        });
        jPanel7.add(pass_petugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 161, 380, -1));

        pass_konfir.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        pass_konfir.setForeground(new java.awt.Color(28, 42, 57));
        pass_konfir.setBorder(null);
        pass_konfir.setScrollOffset(1);
        jPanel7.add(pass_konfir, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 376, -1));

        laki.setBackground(new java.awt.Color(28, 42, 57));
        ambil_kelamin.add(laki);
        laki.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        laki.setForeground(new java.awt.Color(28, 42, 57));
        laki.setText("Laki-Laki");
        laki.setBorder(null);
        laki.setContentAreaFilled(false);
        laki.setFocusPainted(false);
        jPanel7.add(laki, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 150, 20));

        perempuan.setBackground(new java.awt.Color(28, 42, 57));
        ambil_kelamin.add(perempuan);
        perempuan.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        perempuan.setForeground(new java.awt.Color(28, 42, 57));
        perempuan.setText("Perempuan");
        perempuan.setBorder(null);
        perempuan.setContentAreaFilled(false);
        perempuan.setFocusPainted(false);
        jPanel7.add(perempuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, 150, 20));

        jLabel22.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 0, 0));
        jLabel22.setText("* Maksimal 13 karakter");
        jPanel7.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 140, 40));

        reset.setBackground(new java.awt.Color(15, 37, 62));
        reset.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        reset.setForeground(new java.awt.Color(255, 255, 255));
        reset.setText("Reset");
        reset.setBorder(null);
        reset.setContentAreaFilled(false);
        reset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reset.setOpaque(true);
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        jPanel7.add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 473, 92, 37));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 903, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 1350, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        // TODO add your handling code here:
        fungsi.close();
    }//GEN-LAST:event_closeActionPerformed

    private void tabel_petugasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_petugasMouseClicked
        // TODO add your handling code here:
        int baris = tabel_petugas.getSelectedRow();
        petugas_id.setEditable(false);
        tambah.setEnabled(false);
        hapus.setEnabled(true);
        ubah.setEnabled(true);
        ambil_kelamin.setSelected(null,false);
        petugas_id.setText(tabel_petugas.getModel().getValueAt(baris, 0).toString());
        nama_petugas.setText(tabel_petugas.getModel().getValueAt(baris, 1).toString());
        pass_petugas.setText(tabel_petugas.getModel().getValueAt(baris, 2).toString());
        pass_konfir.setText(tabel_petugas.getModel().getValueAt(baris, 2).toString());
        telp_petugas.setText(tabel_petugas.getModel().getValueAt(baris, 4).toString());
        alamat_petugas.setText(tabel_petugas.getModel().getValueAt(baris, 5).toString());
        switch(tabmodel.getValueAt(tabel_petugas.getSelectedRow(), 3).toString()){
            case "Laki-laki" :
                laki.setSelected(true);
                break;
            case "Perempuan" :
                perempuan.setSelected(true);
                break;
        }
        
    }//GEN-LAST:event_tabel_petugasMouseClicked

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        // TODO add your handling code here:
        
        if(kosong()){
            JOptionPane.showMessageDialog(null, "Harap Lengkapi Data !","Kesalahan", JOptionPane.ERROR_MESSAGE);
        }else if(pass_petugas.getText().length()<8){
            JOptionPane.showMessageDialog(null, "Password minimal 8 karakter !","Kesalahan", JOptionPane.ERROR_MESSAGE);
        }else if(tidak_sesuai()){
            JOptionPane.showMessageDialog(null, "Password tidak sesuai !","Kesalahan", JOptionPane.ERROR_MESSAGE);
        }else{
            try {
                st = con.createStatement();
                String sql = "INSERT INTO petugas VALUES('"+ petugas_id.getText() +"','"+ nama_petugas.getText() +"','"+ pass_petugas.getText() +"','"+ ambil_kelamin.getSelection().getActionCommand().toString() +"', '"+ telp_petugas.getText() +"','"+ alamat_petugas.getText() +"')";
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"Berhasil");
                reset();
                tampildata();
                autokode();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Terjadi Kesalahan");
                reset();
            }
        }
    }//GEN-LAST:event_tambahActionPerformed

    private void cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakActionPerformed
        // TODO add your handling code here:
        JasperReport reports;
        
        String path = ".\\src\\Laporan\\laporan_petugas.jasper";
        try {
            reports = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(path, null, con);
            JasperViewer jviewer = new JasperViewer(jprint, false);
            
            jviewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jviewer.setVisible(true);
        } catch (JRException ex) {
            
            Logger.getLogger(lihat_petugas.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }//GEN-LAST:event_cetakActionPerformed

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
        // TODO add your handling code here:
        if(kosong()){
            JOptionPane.showMessageDialog(null, "Harap Lengkapi Data !","Kesalahan", JOptionPane.ERROR_MESSAGE);
        }else if(pass_petugas.getText().length()<8){
            JOptionPane.showMessageDialog(null, "Password minimal 8 karakter !","Kesalahan", JOptionPane.ERROR_MESSAGE);
        }else if(tidak_sesuai()){
            JOptionPane.showMessageDialog(null, "Password tidak sesuai !","Kesalahan", JOptionPane.ERROR_MESSAGE);
        }else{
            try {
            st = con.createStatement();
            String sql = "UPDATE petugas SET nama='"+ nama_petugas.getText() +"', password='"+ pass_petugas.getText() +"',jk_petugas='"+ ambil_kelamin.getSelection().getActionCommand().toString() +"',telp_petugas='"+ telp_petugas.getText() +"',alamat_petugas='"+ alamat_petugas.getText() +"' WHERE id_petugas='"+ petugas_id.getText() +"'";
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Berhasil di ubah");
            reset();
            tampildata();
            } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan");
            reset();
            }
        }
        
    }//GEN-LAST:event_ubahActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // TODO add your handling code here:
        if(!petugas_id.getText().equals("")){
            try {
            int jawab;
            if((jawab = JOptionPane.showConfirmDialog(null,"Hapus data?", "Konfirmasi", JOptionPane.YES_NO_OPTION)) == 0){
                st = con.createStatement();
                sql = "DELETE FROM petugas WHERE id_petugas='"+ petugas_id.getText() +"'";
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"Berhasil di hapus");
                reset();
                tampildata();
            }
            
            } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan");
            reset();
            }
        }else{
            JOptionPane.showMessageDialog(null,"Pilih ID untuk data yang ingin di hapus!");
        }
        
        
    }//GEN-LAST:event_hapusActionPerformed

    private void cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariKeyReleased
        // TODO add your handling code here:
        try {
            st = con.createStatement();
            tabmodel.getDataVector().removeAllElements();
            tabmodel.fireTableDataChanged();
            String cr = cari.getText();
            rs = st.executeQuery("SELECT * FROM petugas WHERE id_petugas like '%"+ cr +"%'or nama like '%"+ cr +"%'or jk_petugas like '%"+ cr +"%' or telp_petugas like '%"+ cr +"%' or alamat_petugas like '%"+ cr +"%'" );
             while (rs.next()){
                    Object[] data ={
                     rs.getString("id_petugas"),
                     rs.getString("nama"),
                     rs.getString("jk_petugas"),
                     rs.getString("telp_petugas"),
                     rs.getString("alamat_petugas"),
                    };
                    tabmodel.addRow(data);
                    }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cariKeyReleased

    private void alamat_petugasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_alamat_petugasKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_alamat_petugasKeyTyped

    private void telp_petugasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telp_petugasKeyTyped
        // TODO add your handling code here:
         if(!Character.isDigit(evt.getKeyChar()) || telp_petugas.getText().length()>=13){
            evt.consume();
        }
    }//GEN-LAST:event_telp_petugasKeyTyped

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cariActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        reset();
        autokode();
    }//GEN-LAST:event_resetActionPerformed

    private void pass_petugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pass_petugasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pass_petugasActionPerformed

    private void cetakMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cetakMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cetakMouseEntered

    private void logout1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout1ActionPerformed
        // TODO add your handling code here:
        halaman_kepalaperpus ho = new halaman_kepalaperpus();
        ho.show();
        this.dispose();
    }//GEN-LAST:event_logout1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(lihat_petugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(lihat_petugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(lihat_petugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(lihat_petugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new lihat_petugas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alamat_petugas;
    private javax.swing.ButtonGroup ambil_kelamin;
    private javax.swing.JTextField cari;
    private javax.swing.JButton cetak;
    private javax.swing.JButton close;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JRadioButton laki;
    private javax.swing.JButton logout1;
    private javax.swing.JTextField nama_petugas;
    private javax.swing.JPasswordField pass_konfir;
    private javax.swing.JPasswordField pass_petugas;
    private javax.swing.JRadioButton perempuan;
    private javax.swing.JTextField petugas_id;
    private javax.swing.JButton reset;
    private javax.swing.JTable tabel_petugas;
    private javax.swing.JButton tambah;
    private javax.swing.JTextField telp_petugas;
    private javax.swing.JButton ubah;
    // End of variables declaration//GEN-END:variables
}
