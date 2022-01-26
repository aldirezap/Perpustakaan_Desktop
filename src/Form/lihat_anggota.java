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
import javafx.scene.control.RadioButton;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
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
public class lihat_anggota extends javax.swing.JFrame {
    public Statement st;
    public ResultSet rs;
    public ResultSet rs2;
    public DefaultTableModel tabmodel;
    String sql;
    Connection con = koneksi.koneksi.getKoneksi(); 
    
    /**
     * Creates new form 
     */
    public lihat_anggota() {
        initComponents();
        anggota();
        tampildata();
        laki.setActionCommand("Laki-laki");
        perempuan.setActionCommand("Perempuan");
        id_anggota.setEditable(false);
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
        nama.setText(null);
        nis.setText(null);
        kelamin.clearSelection();
        telp.setText(null);
        alamat.setText(null);
        tambah.setEnabled(true);
        hapus.setEnabled(false);
        ubah.setEnabled(false);
    }
    
    public Boolean kosong(){
        return (id_anggota.getText().equals("") || nama.getText().equals("") || nis.getText().equals("")
                || (kelamin.getSelection()==null) || telp.getText().equals("") || alamat.getText().equals(""));
    }
    
    
    public void autokode(){
         try{
            String sql;
            sql = "SELECT COUNT(id_anggota) as jumlah FROM anggota";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                String jumlah = rs.getString("jumlah");
                int jumint = Integer.parseInt(String.valueOf(jumlah));
                if (jumint > 0) {
                    st = con.createStatement();
                        sql = "SELECT MAX(id_anggota) AS kode FROM anggota";
                        rs2 = st.executeQuery(sql);
                        if(rs2.next()){
                            String id = rs2.getString("kode").substring(3);
                            String kode = String.valueOf(Integer.parseInt(id) + 1);
                            if(kode.length() == 1){
                               id_anggota.setText("AGT00"+kode);
                            }else if(kode.length() == 2){
                                id_anggota.setText("AGT0"+kode);
                            }else
                                id_anggota.setText("AGT"+kode);
                        }
                }else{
                    id_anggota.setText("AGT001");
                }
            }
        }catch(SQLException e){
            
        }
    }
    
    public void anggota(){
        Object[] judul = {"ID","Nama","NIS","Jenis Kelamin","Telepon","Alamat","Status"};
        tabmodel = new DefaultTableModel(null,judul){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        tabel_anggota.setModel(tabmodel);
    }
    public void anggota_cari(){
        Object[] judul = {"ID","Nama","NIS","Jenis Kelamin","Telepon","Alamat","Status"};
        tabmodel = new DefaultTableModel(null,judul){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        tabel_anggota.setModel(tabmodel);
    }
    public void tampildata(){
        try{
            st = con.createStatement();
            tabmodel.getDataVector().removeAllElements();
            tabmodel.fireTableDataChanged();
            rs = st.executeQuery("SELECT * FROM anggota ORDER BY id_anggota DESC");
            while(rs.next()){
                Object [] data = {
                    rs.getString("id_anggota"),
                    rs.getString("nama_anggota"),
                    rs.getString("nis"),
                    rs.getString("jk_anggota"),
                    rs.getString("telp_anggota"),
                    rs.getString("alamat"),
                    rs.getString("status"),
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

        kelamin = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        close = new javax.swing.JButton();
        logout1 = new javax.swing.JButton();
        cari = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cetak_anggota = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_anggota = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        id_anggota = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        nis = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        telp = new javax.swing.JTextField();
        jSeparator11 = new javax.swing.JSeparator();
        tambah = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        ubah = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        alamat = new javax.swing.JTextField();
        jSeparator12 = new javax.swing.JSeparator();
        laki = new javax.swing.JRadioButton();
        perempuan = new javax.swing.JRadioButton();
        jLabel22 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        reset1 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(31, 70, 112));

        jLabel1.setFont(new java.awt.Font("EngraversGothic BT", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/team.png"))); // NOI18N

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

        jLabel3.setFont(new java.awt.Font("EngraversGothic BT", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("halaman anggota");

        jLabel4.setFont(new java.awt.Font("EngraversGothic BT", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Perpus SMANSAGAS");

        cetak_anggota.setBackground(new java.awt.Color(31, 70, 112));
        cetak_anggota.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        cetak_anggota.setForeground(new java.awt.Color(255, 255, 255));
        cetak_anggota.setText("Cetak");
        cetak_anggota.setBorder(null);
        cetak_anggota.setContentAreaFilled(false);
        cetak_anggota.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cetak_anggota.setOpaque(true);
        cetak_anggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetak_anggotaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(354, 354, 354)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cetak_anggota, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 217, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(462, 462, 462)))
                .addComponent(logout1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(logout1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel4)
                        .addGap(6, 6, 6)
                        .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cetak_anggota, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1510, 120));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tabel_anggota.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        tabel_anggota.setForeground(new java.awt.Color(28, 42, 57));
        tabel_anggota.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_anggota.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabel_anggota.setFocusable(false);
        tabel_anggota.setGridColor(new java.awt.Color(28, 42, 57));
        tabel_anggota.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabel_anggota.setRowHeight(25);
        tabel_anggota.setSelectionBackground(new java.awt.Color(28, 42, 57));
        tabel_anggota.setShowVerticalLines(false);
        tabel_anggota.getTableHeader().setReorderingAllowed(false);
        tabel_anggota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_anggotaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_anggota);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        id_anggota.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        id_anggota.setForeground(new java.awt.Color(28, 42, 57));
        id_anggota.setBorder(null);
        jPanel7.add(id_anggota, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 370, -1));

        jSeparator6.setForeground(new java.awt.Color(28, 42, 57));
        jPanel7.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 59, 390, 10));

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(28, 42, 57));
        jLabel14.setText("ID Anggota");
        jPanel7.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        nis.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        nis.setForeground(new java.awt.Color(28, 42, 57));
        nis.setBorder(null);
        nis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nisActionPerformed(evt);
            }
        });
        jPanel7.add(nis, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 370, -1));

        jSeparator7.setForeground(new java.awt.Color(28, 42, 57));
        jPanel7.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 123, 394, 10));

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(28, 42, 57));
        jLabel15.setText("NIS");
        jPanel7.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 139, -1, -1));

        jSeparator8.setForeground(new java.awt.Color(28, 42, 57));
        jPanel7.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 184, 394, 10));

        jLabel17.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(28, 42, 57));
        jLabel17.setText("Jenis Kelamin");
        jPanel7.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        jLabel18.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(28, 42, 57));
        jLabel18.setText("Telepon");
        jPanel7.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        telp.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        telp.setForeground(new java.awt.Color(28, 42, 57));
        telp.setBorder(null);
        telp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telpKeyTyped(evt);
            }
        });
        jPanel7.add(telp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 370, -1));

        jSeparator11.setForeground(new java.awt.Color(28, 42, 57));
        jPanel7.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 390, 10));

        tambah.setBackground(new java.awt.Color(28, 42, 57));
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
        jPanel7.add(tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 92, 37));

        hapus.setBackground(new java.awt.Color(28, 42, 57));
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
        jPanel7.add(hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 490, 92, 37));

        ubah.setBackground(new java.awt.Color(28, 42, 57));
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
        jPanel7.add(ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 490, 92, 37));

        jLabel20.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(28, 42, 57));
        jLabel20.setText("Alamat");
        jPanel7.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        alamat.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        alamat.setForeground(new java.awt.Color(28, 42, 57));
        alamat.setBorder(null);
        alamat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                alamatKeyTyped(evt);
            }
        });
        jPanel7.add(alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 370, -1));

        jSeparator12.setForeground(new java.awt.Color(28, 42, 57));
        jPanel7.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 390, 10));

        laki.setBackground(new java.awt.Color(28, 42, 57));
        kelamin.add(laki);
        laki.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        laki.setForeground(new java.awt.Color(28, 42, 57));
        laki.setText("Laki-Laki");
        laki.setBorder(null);
        laki.setContentAreaFilled(false);
        laki.setFocusPainted(false);
        jPanel7.add(laki, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 150, 20));

        perempuan.setBackground(new java.awt.Color(28, 42, 57));
        kelamin.add(perempuan);
        perempuan.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        perempuan.setForeground(new java.awt.Color(28, 42, 57));
        perempuan.setText("Perempuan");
        perempuan.setBorder(null);
        perempuan.setContentAreaFilled(false);
        perempuan.setFocusPainted(false);
        jPanel7.add(perempuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 150, 20));

        jLabel22.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 0, 0));
        jLabel22.setText("* Maksimal 13 karakter");
        jPanel7.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 140, 20));

        nama.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        nama.setForeground(new java.awt.Color(28, 42, 57));
        nama.setBorder(null);
        jPanel7.add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 370, -1));

        reset1.setBackground(new java.awt.Color(28, 42, 57));
        reset1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        reset1.setForeground(new java.awt.Color(255, 255, 255));
        reset1.setText("Reset");
        reset1.setBorder(null);
        reset1.setContentAreaFilled(false);
        reset1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reset1.setOpaque(true);
        reset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset1ActionPerformed(evt);
            }
        });
        jPanel7.add(reset1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 490, 92, 37));

        jLabel16.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(28, 42, 57));
        jLabel16.setText("Nama");
        jPanel7.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 75, -1, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1075, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 1510, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        // TODO add your handling code here:
        fungsi.close();
    }//GEN-LAST:event_closeActionPerformed

    private void logout1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout1ActionPerformed
        // TODO add your handling code here:
        halaman_kepalaperpus ho = new halaman_kepalaperpus();
        ho.show();
        this.dispose();
    }//GEN-LAST:event_logout1ActionPerformed

    private void tabel_anggotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_anggotaMouseClicked
        // TODO add your handling code here:
        int baris = tabel_anggota.getSelectedRow();
        id_anggota.setEditable(false);
        tambah.setEnabled(false);
        hapus.setEnabled(true);
        ubah.setEnabled(true);
        kelamin.setSelected(null,false);
        id_anggota.setText(tabel_anggota.getModel().getValueAt(baris, 0).toString());
        nama.setText(tabel_anggota.getModel().getValueAt(baris, 1).toString());
        nis.setText(tabel_anggota.getModel().getValueAt(baris, 2).toString());
        telp.setText(tabel_anggota.getModel().getValueAt(baris, 4).toString());
        alamat.setText(tabel_anggota.getModel().getValueAt(baris, 5).toString());
        switch(tabmodel.getValueAt(tabel_anggota.getSelectedRow(), 3).toString()){
            case "Laki-laki" :
                laki.setSelected(true);
                break;
            case "Perempuan" :
                perempuan.setSelected(true);
                break;
        }
        
    }//GEN-LAST:event_tabel_anggotaMouseClicked

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        // TODO add your handling code here:
        
            if(kosong()){
            JOptionPane.showMessageDialog(null, "Harap Lengkapi Data !","Kesalahan", JOptionPane.ERROR_MESSAGE);
            }else{
            try {
                st = con.createStatement();
                String sql = "INSERT INTO anggota VALUES('"+ id_anggota.getText() +"','"+ nama.getText() +"','"+ nis.getText() +"','"
                            + kelamin.getSelection().getActionCommand().toString() +"', '"+ telp.getText() +"','"+ alamat.getText() +"','Tidak pinjam')";
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

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
        // TODO add your handling code here:
        if(kosong()){
            JOptionPane.showMessageDialog(null, "Harap Lengkapi Data !","Kesalahan", JOptionPane.ERROR_MESSAGE);
        }else{
            try {
            st = con.createStatement();
            String sql = "UPDATE anggota SET nama_anggota='"+ nama.getText() +"', nis='"+ nis.getText() +"',jk_Anggota='"+ kelamin.getSelection().getActionCommand().toString() 
                    +"',telp_anggota='"+ telp.getText() +"',alamat='"+ alamat.getText() +"' WHERE id_anggota='"+ id_anggota.getText() +"'";
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
        if(!id_anggota.getText().equals("")){
            try {
            int baris =tabel_anggota.getSelectedRow();
            String stat = "Pinjam";
            int jawab;
            if(stat.equals(tabel_anggota.getValueAt(baris, 6))){
                JOptionPane.showMessageDialog(null, "Tidak dapat menghapus selama dalam masa peminjaman");
//                reset();
            }else if((jawab = JOptionPane.showConfirmDialog(null,"Hapus data?", "Konfirmasi", JOptionPane.YES_NO_OPTION)) == 0){
                st = con.createStatement();
            sql = "DELETE FROM anggota WHERE id_anggota='"+ id_anggota.getText() +"'";
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
        if(cari.getText().length()>0){
            try {
            st = con.createStatement();
            tabmodel.getDataVector().removeAllElements();
            tabmodel.fireTableDataChanged();
            String cr = cari.getText();
            rs = st.executeQuery("SELECT * FROM anggota WHERE id_anggota like '%"+ cr +"%'or nama_anggota like '%"+ cr +"%'or nis like '%"+ cr +"%'or jk_anggota like '%"
                    + cr +"%' or telp_anggota like '%"+ cr +"%' or alamat like '%"+ cr +"%' or status like '%"+ cr +"%' ORDER BY id_anggota DESC " );
             while (rs.next()){
                    anggota_cari();
                    Object[] data ={
                     rs.getString("id_anggota"),
                     rs.getString("nama_anggota"),
                     rs.getString("nis"),
                     rs.getString("jk_anggota"),
                     rs.getString("telp_anggota"),
                     rs.getString("alamat"),
                     rs.getString("status"),
                    };
                    tabmodel.addRow(data);
                    }
        } catch (Exception e) {
            e.printStackTrace();
        }
        }else{
            anggota();
            tampildata();   
        }
        
    }//GEN-LAST:event_cariKeyReleased

    private void alamatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_alamatKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_alamatKeyTyped

    private void telpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telpKeyTyped
        // TODO add your handling code here:
         if(!Character.isDigit(evt.getKeyChar()) || telp.getText().length()>=13){
            evt.consume();
        }
    }//GEN-LAST:event_telpKeyTyped

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cariActionPerformed

    private void reset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset1ActionPerformed
        // TODO add your handling code here:
        autokode();
        reset();
    }//GEN-LAST:event_reset1ActionPerformed

    private void nisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nisActionPerformed

    private void cetak_anggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetak_anggotaActionPerformed
        // TODO add your handling code here:
                JasperReport reports;
        
        String path = ".\\src\\Laporan\\laporan_anggota.jasper";
        try {
            reports = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(path, null, con);
            JasperViewer jviewer = new JasperViewer(jprint, false);
            
            jviewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jviewer.setVisible(true);
        } catch (JRException ex) {
            
            Logger.getLogger(lihat_anggota.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cetak_anggotaActionPerformed

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
            java.util.logging.Logger.getLogger(lihat_anggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(lihat_anggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(lihat_anggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(lihat_anggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new lihat_anggota().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alamat;
    private javax.swing.JTextField cari;
    private javax.swing.JButton cetak_anggota;
    private javax.swing.JButton close;
    private javax.swing.JButton hapus;
    private javax.swing.JTextField id_anggota;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.ButtonGroup kelamin;
    private javax.swing.JRadioButton laki;
    private javax.swing.JButton logout1;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField nis;
    private javax.swing.JRadioButton perempuan;
    private javax.swing.JButton reset1;
    private javax.swing.JTable tabel_anggota;
    private javax.swing.JButton tambah;
    private javax.swing.JTextField telp;
    private javax.swing.JButton ubah;
    // End of variables declaration//GEN-END:variables

    private static class nis {

        public nis() {
        }
    }
}
