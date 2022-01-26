/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Fungsi.fungsi;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
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
public class lihat_buku_petugas extends javax.swing.JFrame {
    public Statement st;
    public ResultSet rs;
    public ResultSet rs2;
    public DefaultTableModel tabmodel;
    
    String sql;
    Connection con = koneksi.koneksi.getKoneksi(); 
    
    /**
     * Creates new form 
     */
    public lihat_buku_petugas() {
        initComponents();
        judul();
        tampildata();
        kode_buku.setEditable(false);
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
        judul.setText(null);
        penerbit.setText(null);
        tahun.setText(null);
        penulis.setText(null);
        kategori.setText(null);
        isbn.setText(null);
        jumlah.setText(null);
        tambah.setEnabled(true);
        hapus.setEnabled(false);
        ubah.setEnabled(false);
    }
    
    public Boolean tidak_kosong(){
        return !(kode_buku.getText().equals("") || judul.getText().equals("") || penerbit.getText().equals("") || 
                tahun.getText().equals("") || penulis.getText().equals("") ||  kategori.getText().equals("") || jumlah.getText().equals(""));
    }
       
    public void autokode(){
         try{
            
            String sql;
            sql = "SELECT COUNT(kode_buku) as jumlah FROM buku";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                String jumlah = rs.getString("jumlah");
                int jumint = Integer.parseInt(String.valueOf(jumlah));
                if (jumint > 0) {
                    st = con.createStatement();
                        sql = "SELECT MAX(kode_buku) AS kode FROM buku";
                        rs2 = st.executeQuery(sql);
                        if(rs2.next()){
                            String id = rs2.getString("kode").substring(2);
                            String kode = String.valueOf(Integer.parseInt(id) + 1);
                            if(kode.length() == 1){
                               kode_buku.setText("BK00"+kode);
                            }else if(kode.length() == 2){
                                kode_buku.setText("BK0"+kode);
                            }else
                                kode_buku.setText("BK"+kode);
                        }
                }else{
                    kode_buku.setText("BK001");
                }
            }
        }catch(SQLException e){
            
        }
    }
    
    public void judul(){
        Object[] judul = {"Kode","Judul","Penerbit","Tahun Terbit","Penulis","Kategori","ISBN","Jumlah"};
        tabmodel = new DefaultTableModel(null,judul){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        tabel_buku.setModel(tabmodel);
    }
    
    public void tampildata(){
        try{
            st = con.createStatement();
            tabmodel.getDataVector().removeAllElements();
            tabmodel.fireTableDataChanged();
            rs = st.executeQuery("SELECT * FROM buku ORDER BY kode_buku DESC");
            while(rs.next()){
                Object [] data = {
                    rs.getString("kode_buku"),
                    rs.getString("judul"),
                    rs.getString("penerbit"),
                    rs.getString("tahun_terbit"),
                    rs.getString("penulis"),
                    rs.getString("kategori"),
                    rs.getString("isbn"),
                    rs.getString("jumlah"),
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        close = new javax.swing.JButton();
        logout1 = new javax.swing.JButton();
        cari = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_buku = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        kode_buku = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        judul = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        penerbit = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        tahun = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        kategori = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jumlah = new javax.swing.JTextField();
        jSeparator11 = new javax.swing.JSeparator();
        reset = new javax.swing.JButton();
        tambah = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        ubah = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        isbn = new javax.swing.JTextField();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        penulis = new javax.swing.JTextField();
        jSeparator13 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(31, 70, 112));

        jLabel1.setFont(new java.awt.Font("EngraversGothic BT", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/books-stack-of-three (1).png"))); // NOI18N

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
        cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cariKeyReleased(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/magnifying-glass.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("EngraversGothic BT", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Perpus SMANSAGAS");

        jLabel2.setFont(new java.awt.Font("EngraversGothic BT", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("halaman buku");

        jSeparator2.setBackground(new java.awt.Color(240, 240, 240));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(81, 81, 81))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(575, 575, 575)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 605, Short.MAX_VALUE)
                        .addComponent(logout1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(logout1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cari, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel3)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1560, 120));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tabel_buku.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        tabel_buku.setForeground(new java.awt.Color(28, 42, 57));
        tabel_buku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        tabel_buku.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabel_buku.setFocusable(false);
        tabel_buku.setGridColor(new java.awt.Color(28, 42, 57));
        tabel_buku.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabel_buku.setRowHeight(25);
        tabel_buku.setSelectionBackground(new java.awt.Color(28, 42, 57));
        tabel_buku.setShowVerticalLines(false);
        tabel_buku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_bukuMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_buku);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(28, 42, 57));
        jLabel13.setText("Kode Buku");
        jPanel7.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        kode_buku.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        kode_buku.setForeground(new java.awt.Color(28, 42, 57));
        kode_buku.setBorder(null);
        jPanel7.add(kode_buku, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 36, 370, -1));

        jSeparator6.setForeground(new java.awt.Color(28, 42, 57));
        jPanel7.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 59, 390, 10));

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(28, 42, 57));
        jLabel14.setText("Judul Buku");
        jPanel7.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 75, -1, -1));

        judul.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        judul.setForeground(new java.awt.Color(28, 42, 57));
        judul.setBorder(null);
        jPanel7.add(judul, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 370, -1));

        jSeparator7.setForeground(new java.awt.Color(28, 42, 57));
        jPanel7.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 123, 390, 10));

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(28, 42, 57));
        jLabel15.setText("Penerbit");
        jPanel7.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 139, -1, -1));

        penerbit.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        penerbit.setForeground(new java.awt.Color(28, 42, 57));
        penerbit.setBorder(null);
        penerbit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                penerbitActionPerformed(evt);
            }
        });
        jPanel7.add(penerbit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 164, 370, -1));

        jSeparator8.setForeground(new java.awt.Color(28, 42, 57));
        jPanel7.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 187, 390, 10));

        jLabel16.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(28, 42, 57));
        jLabel16.setText("Tahun Terbit");
        jPanel7.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 203, -1, -1));

        tahun.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        tahun.setForeground(new java.awt.Color(28, 42, 57));
        tahun.setBorder(null);
        tahun.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tahunKeyTyped(evt);
            }
        });
        jPanel7.add(tahun, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 228, 370, -1));

        jSeparator9.setForeground(new java.awt.Color(28, 42, 57));
        jPanel7.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 251, 390, 10));

        jLabel17.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(28, 42, 57));
        jLabel17.setText("Kategori");
        jPanel7.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        kategori.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        kategori.setForeground(new java.awt.Color(28, 42, 57));
        kategori.setBorder(null);
        jPanel7.add(kategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 370, -1));

        jSeparator10.setForeground(new java.awt.Color(28, 42, 57));
        jPanel7.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 390, 10));

        jLabel18.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(28, 42, 57));
        jLabel18.setText("Jumlah");
        jPanel7.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, -1, -1));

        jumlah.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jumlah.setForeground(new java.awt.Color(28, 42, 57));
        jumlah.setBorder(null);
        jumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jumlahKeyTyped(evt);
            }
        });
        jPanel7.add(jumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 370, -1));

        jSeparator11.setForeground(new java.awt.Color(28, 42, 57));
        jPanel7.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 390, 10));

        reset.setBackground(new java.awt.Color(28, 42, 57));
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
        jPanel7.add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 620, 92, 37));

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
        jPanel7.add(tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 92, 37));

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
        jPanel7.add(hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 620, 92, 37));

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
        jPanel7.add(ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 620, 92, 37));

        jLabel20.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(28, 42, 57));
        jLabel20.setText("ISBN");
        jPanel7.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, -1, -1));

        isbn.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        isbn.setForeground(new java.awt.Color(28, 42, 57));
        isbn.setBorder(null);
        jPanel7.add(isbn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 370, -1));

        jSeparator12.setForeground(new java.awt.Color(28, 42, 57));
        jPanel7.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 390, 10));

        jLabel21.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(28, 42, 57));
        jLabel21.setText("Penulis");
        jPanel7.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        penulis.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        penulis.setForeground(new java.awt.Color(28, 42, 57));
        penulis.setBorder(null);
        penulis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                penulisKeyTyped(evt);
            }
        });
        jPanel7.add(penulis, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 370, -1));

        jSeparator13.setForeground(new java.awt.Color(28, 42, 57));
        jPanel7.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 390, 10));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1129, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 1560, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        // TODO add your handling code here:
        fungsi.close();
    }//GEN-LAST:event_closeActionPerformed

    private void logout1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout1ActionPerformed
        // TODO add your handling code here:
        halaman_petugas ho = new halaman_petugas();
        ho.show();
        this.dispose();
    }//GEN-LAST:event_logout1ActionPerformed

    private void penerbitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_penerbitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_penerbitActionPerformed

    private void tabel_bukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_bukuMouseClicked
        // TODO add your handling code here:
        int baris = tabel_buku.getSelectedRow();
        kode_buku.setEditable(false);
        tambah.setEnabled(false);
        hapus.setEnabled(true);
        ubah.setEnabled(true);
        kode_buku.setText(tabel_buku.getModel().getValueAt(baris, 0).toString());
        judul.setText(tabel_buku.getModel().getValueAt(baris, 1).toString());
        penerbit.setText(tabel_buku.getModel().getValueAt(baris, 2).toString());
        tahun.setText(tabel_buku.getModel().getValueAt(baris, 3).toString());
        penulis.setText(tabel_buku.getModel().getValueAt(baris, 4).toString());
        kategori.setText(tabel_buku.getModel().getValueAt(baris, 5).toString());
        isbn.setText(tabel_buku.getModel().getValueAt(baris, 6).toString());
        jumlah.setText(tabel_buku.getModel().getValueAt(baris, 7).toString());


        
    }//GEN-LAST:event_tabel_bukuMouseClicked

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        // TODO add your handling code here:
        if(tidak_kosong()){
            try {
                st = con.createStatement();
                String sql = "INSERT INTO buku VALUES('"+ kode_buku.getText() +"','"+ judul.getText() +"','"+ penerbit.getText() +"','"
                        + tahun.getText() +"','"+ penulis.getText() +"','"+ kategori.getText() +"','"+isbn.getText() +"','"+ jumlah.getText() +"')";
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
        else{
            JOptionPane.showMessageDialog(null, "Harap Lengkapi Data !","Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tambahActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        reset();
        autokode();
    }//GEN-LAST:event_resetActionPerformed

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
        // TODO add your handling code here:
        if(tidak_kosong()){
            try {
                st = con.createStatement();
                String sql = "UPDATE buku SET judul='"+ judul.getText() +"', penerbit='"+ penerbit.getText() +"',tahun_terbit='"+ tahun.getText() +"',penulis='"+ penulis.getText()
                        +"',kategori='"+ kategori.getText() +"',isbn='"+ isbn.getText() +"',jumlah='"+ jumlah.getText() +"' WHERE kode_buku='"+ kode_buku.getText() +"'";
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"Berhasil di ubah");
                reset();
                tampildata();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Terjadi Kesalahan");
                reset();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Harap Lengkapi Data !","Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_ubahActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // TODO add your handling code here:
        if(!kode_buku.getText().equals("")){
            try {
                int jawab;
                if((jawab = JOptionPane.showConfirmDialog(null,"Hapus data?", "Konfirmasi", JOptionPane.YES_NO_OPTION)) == 0){
                    st = con.createStatement();
                    sql = "DELETE FROM buku WHERE kode_buku='"+ kode_buku.getText() +"'";
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
            rs = st.executeQuery("SELECT * FROM buku WHERE kode_buku like '%"+ cr +"%'or judul like '%"+ cr +"%'or penerbit like '%"+ cr +"%' or tahun_terbit like '%"+ cr +
                    "%' or penulis like '%"+ cr +"%' or kategori like '%"+ cr +"%' or isbn like '%"+ cr + "%' or jumlah like '%"+ cr +"%' ORDER BY kode_buku DESC " );
             while (rs.next()){
                    Object[] data ={
                     rs.getString("kode_buku"),
                     rs.getString("judul"),
                     rs.getString("penerbit"),
                     rs.getString("tahun_terbit"),
                     rs.getString("penulis"),
                     rs.getString("kategori"),
                     rs.getString("isbn"),
                     rs.getString("jumlah"),
                    };
                    tabmodel.addRow(data);
                    }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cariKeyReleased

    private void tahunKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tahunKeyTyped
        // TODO add your handling code here:
        if(!Character.isDigit(evt.getKeyChar()) || tahun.getText().length()>=4){
            evt.consume();
        }
    }//GEN-LAST:event_tahunKeyTyped

    private void jumlahKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jumlahKeyTyped
        // TODO add your handling code here:
        if(!Character.isDigit(evt.getKeyChar()) || jumlah.getText().length()>=7){
            evt.consume();
        }
    }//GEN-LAST:event_jumlahKeyTyped

    private void penulisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_penulisKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_penulisKeyTyped

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
            java.util.logging.Logger.getLogger(lihat_buku_petugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(lihat_buku_petugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(lihat_buku_petugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(lihat_buku_petugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new lihat_buku_petugas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cari;
    private javax.swing.JButton close;
    private javax.swing.JButton hapus;
    private javax.swing.JTextField isbn;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField judul;
    private javax.swing.JTextField jumlah;
    private javax.swing.JTextField kategori;
    private javax.swing.JTextField kode_buku;
    private javax.swing.JButton logout1;
    private javax.swing.JTextField penerbit;
    private javax.swing.JTextField penulis;
    private javax.swing.JButton reset;
    private javax.swing.JTable tabel_buku;
    private javax.swing.JTextField tahun;
    private javax.swing.JButton tambah;
    private javax.swing.JButton ubah;
    // End of variables declaration//GEN-END:variables
}
