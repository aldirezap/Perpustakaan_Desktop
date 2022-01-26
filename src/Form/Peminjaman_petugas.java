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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Peminjaman_petugas extends javax.swing.JFrame {
    public Statement st;
    public Statement st2;
    public ResultSet rs;
    public ResultSet rs2;
    public DefaultTableModel tabmodel1;
    public DefaultTableModel tabmodel2;
    String sql;
    Connection con = koneksi.koneksi.getKoneksi(); 
    
    /**
     * Creates new form 
     */
    public Peminjaman_petugas() {
        initComponents();
        judul_buku();
        judul_anggota();
        tampildata_anggota();
        tampildata_buku();
        waktu();
        kd_pinjam.setEditable(false);
        id_anggota.setEditable(false);
        nama_anggota.setEditable(false);
        nis.setEditable(false);
        kd_buku.setEditable(false);
        judul_buku.setEditable(false);
        tgl_pinjam.setEditable(false);
        tgl_hrskembali.setEditable(false);
        kode_pinjam();
        setLocationRelativeTo(this);
    }
    
    public void reset(){
        id_anggota.setText(null);
        nama_anggota.setText(null);
        nis.setText(null);
        kd_buku.setText(null);
        judul_buku.setText(null);
    }
    
    public Boolean tidak_kosong(){
        return !(kd_pinjam.getText().equals("") || id_anggota.getText().equals("") || nama_anggota.getText().equals("")|| nis.getText().equals("")|| kd_buku.getText().equals("") 
                || kd_buku.getText().equals("") || judul_buku.getText().equals("") || tgl_pinjam.getText().equals(""));
    }
    
    
    public void waktu(){
        //Date now = new Date();
        //SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");
        //String tgl = format.format(now);
        //tgl_kembali.setText(tgl);
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        tgl_pinjam.setText(df.format(cal.getTime()));
        cal.add(Calendar.DAY_OF_MONTH, 7);
        tgl_hrskembali.setText(df.format(cal.getTime()));
    }
    
    public void kode_pinjam(){
        int kd = (int)(Math.random()*999999);
        kd_pinjam.setText(String.valueOf(kd));
    }
    
    public Boolean kosong(){
        return (kd_pinjam.getText().equals("") || id_anggota.getText().equals("") || nama_anggota.getText().equals("") || nis.getText().equals("")|| kd_buku.getText().equals("") 
                || judul_buku.getText().equals("") || tgl_pinjam.getText().equals("") || tgl_hrskembali.getText().equals(""));
    }
    
    public void judul_buku(){
        Object[] judul = {"Kode","Judul","Penerbit","Tahun Terbit","Penulis","Kategori","ISBN","Jumlah"};
        tabmodel2 = new DefaultTableModel(null,judul){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        tabel_buku.setModel(tabmodel2);
    }
    
    public void judul_anggota(){
        Object[] judul = {"ID","Nama","NIS","Jenis Kelamin","Telepon","Alamat","Status"};
        tabmodel1 = new DefaultTableModel(null,judul){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        tabel_anggota.setModel(tabmodel1);
    }
    
    public void tampildata_anggota(){
        try{
            st = con.createStatement();
            tabmodel1.getDataVector().removeAllElements();
            tabmodel1.fireTableDataChanged();
            rs = st.executeQuery("SELECT * FROM anggota ORDER BY status DESC");
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
                tabmodel1.addRow(data);
                tabmodel1.getRowCount();
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void tampildata_buku(){
        try{
            st = con.createStatement();
            tabmodel2.getDataVector().removeAllElements();
            tabmodel2.fireTableDataChanged();
            rs = st.executeQuery("SELECT * FROM buku ORDER BY jumlah DESC");
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
                tabmodel2.addRow(data);
                tabmodel2.getRowCount();
                
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
        cari_anggota = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_anggota = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        kd_pinjam = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        id_anggota = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        nama_anggota = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        kd_buku = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        judul_buku = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        tgl_pinjam = new javax.swing.JTextField();
        jSeparator11 = new javax.swing.JSeparator();
        reset = new javax.swing.JButton();
        pinjam = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        tgl_hrskembali = new javax.swing.JTextField();
        jSeparator12 = new javax.swing.JSeparator();
        nis = new javax.swing.JTextField();
        jSeparator13 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_buku = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        cari_buku = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel29 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(31, 70, 112));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("EngraversGothic BT", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/upload (1).png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

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
        jPanel1.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 10, 20, 20));

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
        jPanel1.add(logout1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 10, 90, 20));

        cari_anggota.setBackground(new java.awt.Color(31, 70, 112));
        cari_anggota.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        cari_anggota.setForeground(new java.awt.Color(255, 255, 255));
        cari_anggota.setBorder(null);
        cari_anggota.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cari_anggotaKeyReleased(evt);
            }
        });
        jPanel1.add(cari_anggota, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 80, 300, 20));

        jSeparator1.setBackground(new java.awt.Color(240, 240, 240));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 106, 310, 9));

        jLabel19.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Pilih Anggota");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(456, 70, 140, 30));

        jLabel21.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/magnifying-glass.png"))); // NOI18N
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(842, 74, -1, 30));

        jLabel3.setFont(new java.awt.Font("EngraversGothic BT", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("halaman peminjaman");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, -1, -1));

        jLabel4.setFont(new java.awt.Font("EngraversGothic BT", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Perpus SMANSAGAS");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1430, 120));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tabel_anggota.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        tabel_anggota.setForeground(new java.awt.Color(28, 42, 57));
        tabel_anggota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
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

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(28, 42, 57));
        jLabel13.setText("Kode Pinjam");

        kd_pinjam.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        kd_pinjam.setForeground(new java.awt.Color(28, 42, 57));
        kd_pinjam.setBorder(null);

        jSeparator6.setForeground(new java.awt.Color(28, 42, 57));

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(28, 42, 57));
        jLabel14.setText("ID Anggota");

        id_anggota.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        id_anggota.setForeground(new java.awt.Color(28, 42, 57));
        id_anggota.setBorder(null);

        jSeparator7.setForeground(new java.awt.Color(28, 42, 57));

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(28, 42, 57));
        jLabel15.setText("Nama Anggota");

        nama_anggota.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        nama_anggota.setForeground(new java.awt.Color(28, 42, 57));
        nama_anggota.setBorder(null);
        nama_anggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama_anggotaActionPerformed(evt);
            }
        });

        jSeparator8.setForeground(new java.awt.Color(28, 42, 57));

        jLabel16.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(28, 42, 57));
        jLabel16.setText("Kode Buku");

        kd_buku.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        kd_buku.setForeground(new java.awt.Color(28, 42, 57));
        kd_buku.setBorder(null);
        kd_buku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kd_bukuActionPerformed(evt);
            }
        });

        jSeparator9.setForeground(new java.awt.Color(28, 42, 57));

        jLabel17.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(28, 42, 57));
        jLabel17.setText("Judul Buku");

        judul_buku.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        judul_buku.setForeground(new java.awt.Color(28, 42, 57));
        judul_buku.setBorder(null);
        judul_buku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                judul_bukuActionPerformed(evt);
            }
        });

        jSeparator10.setForeground(new java.awt.Color(28, 42, 57));

        jLabel18.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(28, 42, 57));
        jLabel18.setText("Tanggal Pinjam");

        tgl_pinjam.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        tgl_pinjam.setForeground(new java.awt.Color(28, 42, 57));
        tgl_pinjam.setBorder(null);
        tgl_pinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tgl_pinjamActionPerformed(evt);
            }
        });

        jSeparator11.setForeground(new java.awt.Color(28, 42, 57));

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

        pinjam.setBackground(new java.awt.Color(28, 42, 57));
        pinjam.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pinjam.setForeground(new java.awt.Color(255, 255, 255));
        pinjam.setText("Pinjam");
        pinjam.setBorder(null);
        pinjam.setContentAreaFilled(false);
        pinjam.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pinjam.setOpaque(true);
        pinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pinjamActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(28, 42, 57));
        jLabel20.setText("Tanggal Harus Kembali");

        tgl_hrskembali.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        tgl_hrskembali.setForeground(new java.awt.Color(28, 42, 57));
        tgl_hrskembali.setBorder(null);

        jSeparator12.setForeground(new java.awt.Color(28, 42, 57));

        nis.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        nis.setForeground(new java.awt.Color(28, 42, 57));
        nis.setBorder(null);
        nis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nisActionPerformed(evt);
            }
        });

        jSeparator13.setForeground(new java.awt.Color(28, 42, 57));

        jLabel22.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(28, 42, 57));
        jLabel22.setText("NIS");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nama_anggota, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(id_anggota, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(kd_pinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(nis, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(kd_buku, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(judul_buku, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tgl_pinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(pinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2)))
                        .addGap(0, 35, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tgl_hrskembali, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel13)
                .addGap(5, 5, 5)
                .addComponent(kd_pinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel14)
                .addGap(6, 6, 6)
                .addComponent(id_anggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nama_anggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(kd_buku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(judul_buku, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tgl_pinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tgl_hrskembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tabel_buku.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        tabel_buku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel_buku.setFocusable(false);
        tabel_buku.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabel_buku.setRowHeight(25);
        tabel_buku.setShowVerticalLines(false);
        tabel_buku.getTableHeader().setReorderingAllowed(false);
        tabel_buku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_bukuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_buku);

        jPanel6.setBackground(new java.awt.Color(31, 70, 112));

        jLabel28.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/magnifying-glass.png"))); // NOI18N

        cari_buku.setBackground(new java.awt.Color(31, 70, 112));
        cari_buku.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        cari_buku.setForeground(new java.awt.Color(255, 255, 255));
        cari_buku.setBorder(null);
        cari_buku.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cari_bukuKeyReleased(evt);
            }
        });

        jSeparator5.setBackground(new java.awt.Color(240, 240, 240));

        jLabel29.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Pilih Buku");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(248, 248, 248)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cari_buku, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(237, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cari_buku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 1430, 700));

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

    private void cari_anggotaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cari_anggotaKeyReleased
        // TODO add your handling code here:
        try {
            st = con.createStatement();
            tabmodel1.getDataVector().removeAllElements();
            tabmodel1.fireTableDataChanged();
            String cr = cari_anggota.getText();
            rs = st.executeQuery("SELECT * FROM anggota WHERE id_anggota like '%"+ cr +"%'or nama_anggota like '%"+ cr +"%'or nis like '%"+ cr +"%'or jk_anggota like '%"+ cr +
                    "%' or telp_anggota like '%"+ cr +"%' or alamat like '%"+ cr +"%' or status like '%"+ cr +"%' ORDER BY status DESC " );
             while (rs.next()){
                    Object[] data ={
                     rs.getString("id_anggota"),
                     rs.getString("nama_anggota"),
                     rs.getString("nis"),
                     rs.getString("jk_anggota"),
                     rs.getString("telp_anggota"),
                     rs.getString("alamat"),
                     rs.getString("status"),
                    };
                    tabmodel1.addRow(data);
                    }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cari_anggotaKeyReleased

    private void tabel_anggotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_anggotaMouseClicked
        // TODO add your handling code here:
        int baris = tabel_anggota.getSelectedRow();
        String stat = "Pinjam";
        
        if(stat.equals(tabel_anggota.getValueAt(baris, 5))){
            JOptionPane.showMessageDialog(null, "Sedang dalam masa peminjaman  !","Kesalahan", JOptionPane.ERROR_MESSAGE);  
        }else{
            id_anggota.setText(tabel_anggota.getModel().getValueAt(baris, 0).toString());
            nama_anggota.setText(tabel_anggota.getModel().getValueAt(baris, 1).toString());
            nis.setText(tabel_anggota.getModel().getValueAt(baris, 2).toString());
        }
    }//GEN-LAST:event_tabel_anggotaMouseClicked

    private void cari_bukuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cari_bukuKeyReleased
        // TODO add your handling code here:
        try {
            st = con.createStatement();
            tabmodel2.getDataVector().removeAllElements();
            tabmodel2.fireTableDataChanged();
            String cr = cari_buku.getText();
            rs = st.executeQuery("SELECT * FROM buku WHERE kode_buku like '%"+ cr +"%'or judul like '%"+ cr +"%'or penerbit like '%"+ cr +
                    "%' or tahun_terbit like '%"+ cr + "%' or penulis like '%"+ cr +"%' or kategori like '%"+ cr +"%' or isbn like '%"+ cr +"%' or jumlah like '%"+ cr +"%' ORDER BY jumlah DESC " );
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
                    tabmodel2.addRow(data);
                    }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cari_bukuKeyReleased

    private void tabel_bukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_bukuMouseClicked
        // TODO add your handling code here:
        int baris = tabel_buku.getSelectedRow();
        String stok = "0";
        if(stok.equals(tabel_buku.getValueAt(baris, 5))){
            JOptionPane.showMessageDialog(null, "Stok buku habis !","Kesalahan", JOptionPane.ERROR_MESSAGE);  
        }else{
            kd_buku.setText(tabel_buku.getModel().getValueAt(baris, 0).toString());
            judul_buku.setText(tabel_buku.getModel().getValueAt(baris, 1).toString());
        }
        
    }//GEN-LAST:event_tabel_bukuMouseClicked

    private void nisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nisActionPerformed

    private void pinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pinjamActionPerformed
        // TODO add your handling code here:
        if(kosong()){
            JOptionPane.showMessageDialog(null, "Harap Lengkapi Data !","Kesalahan", JOptionPane.ERROR_MESSAGE);
        }else{
            try {
                String sql = "INSERT INTO peminjaman VALUES('"+ kd_pinjam.getText() +"','"+ id_anggota.getText() +"','"+ nama_anggota.getText() +"','"+ nis.getText() +"','"+kd_buku.getText() +"',"
                + " '"+ judul_buku.getText() +"','"+ tgl_pinjam.getText() +"','"+ tgl_hrskembali.getText() +"','1','Belum kembali')";
                String sql2 = "UPDATE anggota set status='Pinjam' WHERE id_anggota='"+ id_anggota.getText() +"'";
                st = con.prepareStatement(sql);
                st2 = con.prepareStatement(sql2);
                st.executeUpdate(sql);
                st2.executeUpdate(sql2);
                JOptionPane.showMessageDialog(null,"Berhasil");
                reset();
                tampildata_anggota();
                tampildata_buku();
                waktu();
                kode_pinjam();
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Terjadi Kesalahan");
                reset();
            }
        }
    }//GEN-LAST:event_pinjamActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_resetActionPerformed

    private void tgl_pinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tgl_pinjamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tgl_pinjamActionPerformed

    private void judul_bukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_judul_bukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_judul_bukuActionPerformed

    private void kd_bukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kd_bukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kd_bukuActionPerformed

    private void nama_anggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama_anggotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama_anggotaActionPerformed

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
            java.util.logging.Logger.getLogger(Peminjaman_petugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Peminjaman_petugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Peminjaman_petugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Peminjaman_petugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new Peminjaman_petugas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cari_anggota;
    private javax.swing.JTextField cari_buku;
    private javax.swing.JButton close;
    private javax.swing.JTextField id_anggota;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField judul_buku;
    private javax.swing.JTextField kd_buku;
    private javax.swing.JTextField kd_pinjam;
    private javax.swing.JButton logout1;
    private javax.swing.JTextField nama_anggota;
    private javax.swing.JTextField nis;
    private javax.swing.JButton pinjam;
    private javax.swing.JButton reset;
    private javax.swing.JTable tabel_anggota;
    private javax.swing.JTable tabel_buku;
    private javax.swing.JTextField tgl_hrskembali;
    private javax.swing.JTextField tgl_pinjam;
    // End of variables declaration//GEN-END:variables
}
