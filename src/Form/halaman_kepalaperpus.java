/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Fungsi.fungsi;
import com.sun.media.jfxmedia.events.NewFrameEvent;
import java.awt.Button;
import java.sql.Connection;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JViewport;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import static koneksi.koneksi.con;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
        
 

/**
 *
 * @author User
 */
public class halaman_kepalaperpus extends javax.swing.JFrame {

    /**
     * Creates new form 
     */
    public void Timer() {
        Timer t2 = new Timer();
        t2.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                time.setText(new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(new java.util.Date()));
            }
        }, 0, 1000);

        /// Membuat label berjalan
        Timer t3 = new Timer();
        t3.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

            }
        }, 0, 80);
    }
    public halaman_kepalaperpus() {
        initComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation(
        (screenSize.width - frameSize.width) / 2,
        (screenSize.height - frameSize.height) / 2);
        Timer();
    }
    
    public void setColor(JPanel panel){
        panel.setBackground(new java.awt.Color(197, 211, 226));
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        logout = new javax.swing.JButton();
        close = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        body = new javax.swing.JPanel();
        jPanel_buku = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        buku = new javax.swing.JButton();
        jPanel_petugas = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        petugas = new javax.swing.JButton();
        jPanel_pinjam = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        peminjaman = new javax.swing.JButton();
        jPanel_kembali = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        pegembalian = new javax.swing.JButton();
        jPanel_history = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        transaksi = new javax.swing.JButton();
        jPanel_laporan = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        laporan = new javax.swing.JButton();
        jPanel_anggota = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        anggota = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(31, 70, 112));
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logout.setBackground(new java.awt.Color(28, 42, 57));
        logout.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        logout.setForeground(new java.awt.Color(255, 255, 255));
        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/login.png"))); // NOI18N
        logout.setText("Logout");
        logout.setToolTipText("Keluar");
        logout.setBorder(null);
        logout.setBorderPainted(false);
        logout.setContentAreaFilled(false);
        logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logout.setFocusPainted(false);
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        header.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 80, -1));

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
        header.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 10, 20, 20));

        jLabel1.setFont(new java.awt.Font("EngraversGothic BT", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logo.png"))); // NOI18N
        header.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 110));

        jLabel2.setFont(new java.awt.Font("EngraversGothic BT", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PERPUSTAKAAN");
        header.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, -1, 60));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("SMA Negeri 1 Cimaragas");
        header.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, 220, -1));

        jLabel16.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("JL. RAYA CIMARAGAS NO.139 B CIMARAGAS, Cimaragas, Kec. Cimaragas, Kab. Ciamis Prov. Jawa Barat");
        header.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 720, -1));

        time.setForeground(new java.awt.Color(255, 255, 255));
        header.add(time, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, 160, 20));

        getContentPane().add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 260));

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_buku.setBackground(new java.awt.Color(31, 70, 112));
        jPanel_buku.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel_buku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel_bukuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel_bukuMouseExited(evt);
            }
        });
        jPanel_buku.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/open-magazine (1).png"))); // NOI18N
        jPanel_buku.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 70, 70));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Buku");
        jPanel_buku.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 50, 20));

        buku.setBackground(new java.awt.Color(156, 170, 185));
        buku.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        buku.setForeground(new java.awt.Color(255, 255, 255));
        buku.setBorder(null);
        buku.setContentAreaFilled(false);
        buku.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bukuMouseEntered(evt);
            }
        });
        buku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bukuActionPerformed(evt);
            }
        });
        jPanel_buku.add(buku, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 110, 70));

        body.add(jPanel_buku, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 150, 140));

        jPanel_petugas.setBackground(new java.awt.Color(92, 133, 177));
        jPanel_petugas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel_petugasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel_petugasMouseExited(evt);
            }
        });
        jPanel_petugas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user-account-box_2.png"))); // NOI18N
        jPanel_petugas.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 29, -1, 57));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Petugas");
        jPanel_petugas.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 90, 30));

        petugas.setBackground(new java.awt.Color(156, 170, 185));
        petugas.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        petugas.setForeground(new java.awt.Color(255, 255, 255));
        petugas.setBorder(null);
        petugas.setContentAreaFilled(false);
        petugas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        petugas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                petugasMouseEntered(evt);
            }
        });
        petugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                petugasActionPerformed(evt);
            }
        });
        jPanel_petugas.add(petugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 100, 70));

        body.add(jPanel_petugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 440, 150, 140));

        jPanel_pinjam.setBackground(new java.awt.Color(92, 133, 177));
        jPanel_pinjam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel_pinjamMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel_pinjamMouseExited(evt);
            }
        });
        jPanel_pinjam.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/upload (1).png"))); // NOI18N
        jPanel_pinjam.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 21, -1, -1));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Peminjaman");
        jPanel_pinjam.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 110, 30));

        peminjaman.setBackground(new java.awt.Color(156, 170, 185));
        peminjaman.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        peminjaman.setForeground(new java.awt.Color(255, 255, 255));
        peminjaman.setBorder(null);
        peminjaman.setContentAreaFilled(false);
        peminjaman.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        peminjaman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                peminjamanMouseEntered(evt);
            }
        });
        peminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peminjamanActionPerformed(evt);
            }
        });
        jPanel_pinjam.add(peminjaman, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 100, 80));

        body.add(jPanel_pinjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, 150, 140));

        jPanel_kembali.setBackground(new java.awt.Color(56, 103, 155));
        jPanel_kembali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel_kembaliMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel_kembaliMouseExited(evt);
            }
        });
        jPanel_kembali.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/download (1).png"))); // NOI18N
        jPanel_kembali.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 20, -1, -1));

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Pengembalian");
        jPanel_kembali.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 140, 30));

        pegembalian.setBackground(new java.awt.Color(156, 170, 185));
        pegembalian.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        pegembalian.setForeground(new java.awt.Color(255, 255, 255));
        pegembalian.setBorder(null);
        pegembalian.setContentAreaFilled(false);
        pegembalian.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pegembalian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pegembalianMouseEntered(evt);
            }
        });
        pegembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pegembalianActionPerformed(evt);
            }
        });
        jPanel_kembali.add(pegembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 110, 90));

        body.add(jPanel_kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, 150, 140));

        jPanel_history.setBackground(new java.awt.Color(56, 103, 155));
        jPanel_history.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel_historyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel_historyMouseExited(evt);
            }
        });
        jPanel_history.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/import-export-arrows.png"))); // NOI18N
        jPanel_history.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 20, -1, -1));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("History");
        jPanel_history.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 90, 30));

        transaksi.setBackground(new java.awt.Color(156, 170, 185));
        transaksi.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        transaksi.setForeground(new java.awt.Color(255, 255, 255));
        transaksi.setBorder(null);
        transaksi.setContentAreaFilled(false);
        transaksi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        transaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                transaksiMouseEntered(evt);
            }
        });
        transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transaksiActionPerformed(evt);
            }
        });
        jPanel_history.add(transaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 100, 80));

        body.add(jPanel_history, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 150, 140));

        jPanel_laporan.setBackground(new java.awt.Color(31, 70, 112));
        jPanel_laporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel_laporanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel_laporanMouseExited(evt);
            }
        });
        jPanel_laporan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/document (1).png"))); // NOI18N
        jPanel_laporan.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 20, 72, -1));

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Laporan");
        jPanel_laporan.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 90, 30));

        laporan.setBackground(new java.awt.Color(156, 170, 185));
        laporan.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        laporan.setForeground(new java.awt.Color(255, 255, 255));
        laporan.setBorder(null);
        laporan.setContentAreaFilled(false);
        laporan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        laporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                laporanMouseEntered(evt);
            }
        });
        laporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laporanActionPerformed(evt);
            }
        });
        jPanel_laporan.add(laporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 110, 80));

        body.add(jPanel_laporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 300, 150, 140));

        jPanel_anggota.setBackground(new java.awt.Color(92, 133, 177));
        jPanel_anggota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel_anggotaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel_anggotaMouseExited(evt);
            }
        });
        jPanel_anggota.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/group (1).png"))); // NOI18N
        jPanel_anggota.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 29, -1, 57));

        jLabel18.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Anggota");
        jPanel_anggota.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 90, 30));

        anggota.setBackground(new java.awt.Color(156, 170, 185));
        anggota.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        anggota.setForeground(new java.awt.Color(255, 255, 255));
        anggota.setBorder(null);
        anggota.setContentAreaFilled(false);
        anggota.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        anggota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                anggotaMouseEntered(evt);
            }
        });
        anggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anggotaActionPerformed(evt);
            }
        });
        jPanel_anggota.add(anggota, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 100, 70));

        body.add(jPanel_anggota, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, 150, 140));

        getContentPane().add(body, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 980, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        int selectedOption = JOptionPane.showConfirmDialog(null,"Keluar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (selectedOption == JOptionPane.YES_OPTION) {
        Login lg = new Login();
        lg.show();
        this.dispose();
        }
    }//GEN-LAST:event_logoutActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        // TODO add your handling code here:
        fungsi.close();
    }//GEN-LAST:event_closeActionPerformed

    private void jPanel_petugasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_petugasMouseEntered
        // TODO add your handling code here:
        setColor(jPanel_petugas);
    }//GEN-LAST:event_jPanel_petugasMouseEntered

    private void jPanel_pinjamMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_pinjamMouseEntered
        // TODO add your handling code here:
        setColor(jPanel_pinjam);
    }//GEN-LAST:event_jPanel_pinjamMouseEntered

    private void jPanel_kembaliMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_kembaliMouseEntered
        // TODO add your handling code here:
        setColor(jPanel_kembali);
    }//GEN-LAST:event_jPanel_kembaliMouseEntered

    private void jPanel_historyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_historyMouseEntered
        // TODO add your handling code here:
        setColor(jPanel_history);
    }//GEN-LAST:event_jPanel_historyMouseEntered

    private void jPanel_laporanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_laporanMouseEntered
        // TODO add your handling code here:
        setColor(jPanel_laporan);
    }//GEN-LAST:event_jPanel_laporanMouseEntered

    private void jPanel_petugasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_petugasMouseExited
        // TODO add your handling code here:
                jPanel_petugas.setBackground(new java.awt.Color(92,133,177));

    }//GEN-LAST:event_jPanel_petugasMouseExited

    private void jPanel_pinjamMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_pinjamMouseExited
        // TODO add your handling code here:
                jPanel_pinjam.setBackground(new java.awt.Color(92,133,177));

    }//GEN-LAST:event_jPanel_pinjamMouseExited

    private void jPanel_kembaliMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_kembaliMouseExited
        // TODO add your handling code here:
                jPanel_kembali.setBackground(new java.awt.Color(56,103,155));

    }//GEN-LAST:event_jPanel_kembaliMouseExited

    private void jPanel_historyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_historyMouseExited
        // TODO add your handling code here:
                jPanel_history.setBackground(new java.awt.Color(56,103,155));

    }//GEN-LAST:event_jPanel_historyMouseExited

    private void jPanel_laporanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_laporanMouseExited
        // TODO add your handling code here:
                jPanel_laporan.setBackground(new java.awt.Color(31,70,112));

    }//GEN-LAST:event_jPanel_laporanMouseExited

    private void jPanel_bukuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_bukuMouseExited
        // TODO add your handling code here:
        jPanel_buku.setBackground(new java.awt.Color(31,70,112)); 
    }//GEN-LAST:event_jPanel_bukuMouseExited

    private void jPanel_bukuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_bukuMouseEntered
        // TODO add your handling code here:
        setColor(jPanel_buku);
    }//GEN-LAST:event_jPanel_bukuMouseEntered

    private void petugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_petugasActionPerformed
        // TODO add your handling code here:
        lihat_petugas la = new lihat_petugas();
        la.show();
        this.dispose();
    }//GEN-LAST:event_petugasActionPerformed

    private void peminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peminjamanActionPerformed
        // TODO add your handling code here:
        Peminjaman pm = new Peminjaman();
        pm.show();
        this.dispose();
    }//GEN-LAST:event_peminjamanActionPerformed

    private void pegembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pegembalianActionPerformed
        // TODO add your handling code here:
        Pengembalian pb = new Pengembalian();
        pb.show();
        this.dispose();
    }//GEN-LAST:event_pegembalianActionPerformed

    private void transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transaksiActionPerformed
        // TODO add your handling code here:
        lihat_history tr = new lihat_history();
        tr.show();
        this.dispose();
    }//GEN-LAST:event_transaksiActionPerformed

    @SuppressWarnings("empty-statement")
    private void laporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laporanActionPerformed
        // TODO add your handling code here:
        JasperReport reports;
        
//        String path = ".\\src\\Laporan\\laporan_transaksi.jasper";
        try {
    
            String Response = JOptionPane.showInputDialog(null, " Masukkan Bulan \n contoh : 10","Laporan Per-Bulan", JOptionPane.QUESTION_MESSAGE);
            String Response1 = JOptionPane.showInputDialog(null, " Masukkan Tahun \n contoh : 2020","Laporan Per-Tahun", JOptionPane.QUESTION_MESSAGE);
            String path = ".\\src\\Laporan\\laporan_transaksi_perbulan.jasper";
            HashMap parameter = new HashMap();
            parameter.put("pbulan", Response);
            parameter.put("ptahun", Response1);
            reports = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(path, parameter, con);
            JasperViewer jviewer = new JasperViewer(jprint, false);
            JasperViewer.setDefaultLookAndFeelDecorated(true);;
            
            jviewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jviewer.setVisible(true);
        } catch (JRException ex) {
            
            JOptionPane.showMessageDialog(null, "Data tidak dapat di Cetak", "Cetak Data", JOptionPane.ERROR_MESSAGE);;
        }
//try{
//    String Response = JOptionPane.showInputDialog(null, " Masukkan Bulan \n contoh : 10","Laporan Per-Bulan", JOptionPane.QUESTION_MESSAGE);
//    String Response1 = JOptionPane.showInputDialog(null, " Masukkan Tahun \n contoh : 2020","Laporan Per-Tahun", JOptionPane.QUESTION_MESSAGE);
//    String NamaFile = "src/Laporan/laporan_transaksi.jasper";
//    HashMap parameter = new HashMap();
//    parameter.put("dt1", Response);
//    parameter.put("dt2", Response1);
//    File reportfile = new File(NamaFile);
//    JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(reportfile.getPath());
//    JasperPrint jasperPrint =JasperFillManager.fillReport(jasperReport, parameter,con);
//    JasperViewer.viewReport(jasperPrint, false);
//    JasperViewer.setDefaultLookAndFeelDecorated(true);;
//    
//}       catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Data tidak dapat di Cetak", "Cetak Data", JOptionPane.ERROR_MESSAGE);
//        }

    }//GEN-LAST:event_laporanActionPerformed

    private void petugasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_petugasMouseEntered
        // TODO add your handling code here:
        setColor(jPanel_petugas);
    }//GEN-LAST:event_petugasMouseEntered

    private void peminjamanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_peminjamanMouseEntered
        // TODO add your handling code here:
        setColor(jPanel_pinjam);
    }//GEN-LAST:event_peminjamanMouseEntered

    private void pegembalianMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pegembalianMouseEntered
        // TODO add your handling code here:
        setColor(jPanel_kembali);
    }//GEN-LAST:event_pegembalianMouseEntered

    private void transaksiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transaksiMouseEntered
        // TODO add your handling code here:
        setColor(jPanel_history);
    }//GEN-LAST:event_transaksiMouseEntered

    private void laporanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laporanMouseEntered
        // TODO add your handling code here:
        setColor(jPanel_laporan);
    }//GEN-LAST:event_laporanMouseEntered

    private void bukuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bukuMouseEntered
        // TODO add your handling code here:
        setColor(jPanel_buku);
    }//GEN-LAST:event_bukuMouseEntered

    private void bukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bukuActionPerformed
        // TODO add your handling code here:
        lihat_buku lh = new lihat_buku();
        lh.show();
        this.dispose();
    }//GEN-LAST:event_bukuActionPerformed

    private void anggotaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_anggotaMouseEntered
        // TODO add your handling code here:
        setColor(jPanel_anggota);
    }//GEN-LAST:event_anggotaMouseEntered

    private void anggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anggotaActionPerformed
        // TODO add your handling code here:
        lihat_anggota la = new lihat_anggota();
        la.show();
        this.dispose();
    }//GEN-LAST:event_anggotaActionPerformed

    private void jPanel_anggotaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_anggotaMouseEntered
        // TODO add your handling code here:
        setColor(jPanel_anggota);
    }//GEN-LAST:event_jPanel_anggotaMouseEntered

    private void jPanel_anggotaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_anggotaMouseExited
        // TODO add your handling code here:
        jPanel_anggota.setBackground(new java.awt.Color(92,133,177));
    }//GEN-LAST:event_jPanel_anggotaMouseExited

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
            java.util.logging.Logger.getLogger(halaman_kepalaperpus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(halaman_kepalaperpus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(halaman_kepalaperpus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(halaman_kepalaperpus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new halaman_kepalaperpus().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anggota;
    private javax.swing.JPanel body;
    private javax.swing.JButton buku;
    private javax.swing.JButton close;
    private javax.swing.JPanel header;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel_anggota;
    private javax.swing.JPanel jPanel_buku;
    private javax.swing.JPanel jPanel_history;
    private javax.swing.JPanel jPanel_kembali;
    private javax.swing.JPanel jPanel_laporan;
    private javax.swing.JPanel jPanel_petugas;
    private javax.swing.JPanel jPanel_pinjam;
    private javax.swing.JButton laporan;
    private javax.swing.JButton logout;
    private javax.swing.JButton pegembalian;
    private javax.swing.JButton peminjaman;
    private javax.swing.JButton petugas;
    private javax.swing.JLabel time;
    private javax.swing.JButton transaksi;
    // End of variables declaration//GEN-END:variables
}
