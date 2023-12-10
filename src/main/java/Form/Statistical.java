/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Form;

import DAO.HoaDonDAO;
import Entity.HoaDon;
import ThuVien.DialogHelper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author nguyenvanquyet
 */
public class Statistical extends javax.swing.JInternalFrame {

    /**
     * Creates new form Statistical
     */
    HoaDonDAO daohd = new HoaDonDAO();

    public Statistical() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        fillComboBoxNam();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablethongkedoanhthu = new javax.swing.JTable();
        cbbNam = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbldoanhthu = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblhoaDon = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblkhachHang = new javax.swing.JLabel();
        jdate = new com.toedter.calendar.JDateChooser();
        btnTimKiem = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setBorder(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tablethongkedoanhthu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "MaHD", "MaKH", "MaNV", "NgayDonHang", "MaBan", "ThanhTien", "TrangThai"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablethongkedoanhthu);

        cbbNam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbNamActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(176, 166, 149));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Combo Chart.png"))); // NOI18N
        jLabel1.setText("Doanh Thu");

        lbldoanhthu.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbldoanhthu.setForeground(new java.awt.Color(204, 0, 0));
        lbldoanhthu.setText("72.200.000 VND");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbldoanhthu)
                    .addComponent(jLabel1))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbldoanhthu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(176, 166, 149));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bill.png"))); // NOI18N
        jLabel2.setText("Hóa đơn");

        lblhoaDon.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblhoaDon.setForeground(new java.awt.Color(255, 0, 51));
        lblhoaDon.setText("10");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(lblhoaDon))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel2)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblhoaDon)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(176, 166, 149));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Customer.png"))); // NOI18N
        jLabel3.setText("Khách hàng");

        lblkhachHang.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblkhachHang.setForeground(new java.awt.Color(255, 0, 0));
        lblkhachHang.setText("10");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(lblkhachHang))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel3)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblkhachHang)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnTimKiem.setBackground(new java.awt.Color(176, 166, 149));
        btnTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(176, 166, 149));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Biểu đồ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cbbNam, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(60, 60, 60)
                        .addComponent(jdate, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTimKiem)))
                .addContainerGap(130, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbbNam)
                    .addComponent(jdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbbNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbNamActionPerformed
        fillDoanhThu();
        fillhoadonNam();
        filltongkhachhangtheonam();
        filltableThongkeHoaDon();
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbNamActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        fillNgayThangNamDoanhthu();
        fillNgayThangNamHoaDon();
        fillNgayThangNamKhachhang();
        filltableThongkeHoaDonjdate();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        fillChart();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JComboBox<String> cbbNam;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdate;
    private javax.swing.JLabel lbldoanhthu;
    private javax.swing.JLabel lblhoaDon;
    private javax.swing.JLabel lblkhachHang;
    private javax.swing.JTable tablethongkedoanhthu;
    // End of variables declaration//GEN-END:variables

    void fillComboBoxNam() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbbNam.getModel();
        model.removeAllElements();
        List<HoaDon> list = daohd.selectAll();
        for (HoaDon hd : list) {
            int nam = hd.getNgayDatHang().getYear() + 1900;
            if (model.getIndexOf(nam) < 0) {
                model.addElement(nam);
            }
        }
    }
//   void tinhdoanhthu(){
//       Object nam = cbbNam.getSelectedItem();
//       if(nam != null){
//           List<HoaDon> list = daohd.selectThongKe((int) nam);
//           lbldoanhthu.setText(list);
//       }
//   }

    void fillDoanhThu() {
        Object ngay = cbbNam.getSelectedItem();
        if (ngay != null) {
            int doanhthutheonam = daohd.getDoanhThu((int) ngay);
            lbldoanhthu.setText(String.valueOf(doanhthutheonam) + " " + "VND");
            System.out.println(doanhthutheonam);
        }
    }

    void fillhoadonNam() {
        Object ngay = cbbNam.getSelectedItem();
        if (ngay != null) {
            int tonghoadonnam = daohd.getTonghoadonNam((int) ngay);
            lblhoaDon.setText(String.valueOf(tonghoadonnam));
            System.out.println(tonghoadonnam);
        }
    }

    void filltongkhachhangtheonam() {
        Object ngay = cbbNam.getSelectedItem();
        if (ngay != null) {
            int Tongkhachhang = daohd.getkhachHangTheoNam((int) ngay);
            lblkhachHang.setText(String.valueOf(Tongkhachhang));
            System.out.println(Tongkhachhang);
        }
    }

    void fillNgayThangNamDoanhthu() {
        Date ngaythangnam = jdate.getDate();
        LocalDate localDate = ngaythangnam.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int ngay = localDate.getDayOfMonth();
        int thang = localDate.getMonthValue();
        int nam = localDate.getYear();
        if (localDate != null) {
            int tongdoanhthu = daohd.getdoanhThu(ngay, thang, nam);
            lbldoanhthu.setText(String.valueOf(tongdoanhthu + " " + "VND"));
        }
    }

    void fillNgayThangNamKhachhang() {
        Date ngaythangnam = jdate.getDate();
        LocalDate localDate = ngaythangnam.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int ngay = localDate.getDayOfMonth();
        int thang = localDate.getMonthValue();
        int nam = localDate.getYear();
        if (localDate != null) {
            int tongkhachhang = daohd.getkhachhang(ngay, thang, nam);
            lblkhachHang.setText(String.valueOf(tongkhachhang));
        }
    }

    void fillNgayThangNamHoaDon() {
        Date ngaythangnam = jdate.getDate();
        LocalDate localDate = ngaythangnam.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int ngay = localDate.getDayOfMonth();
        int thang = localDate.getMonthValue();
        int nam = localDate.getYear();
        if (localDate != null) {
            int tonghoadon = daohd.gethoadon(ngay, thang, nam);
            lblhoaDon.setText(String.valueOf(tonghoadon));
        }
    }

    void filltableThongkeHoaDon() {
        Object date = cbbNam.getSelectedItem();
        System.out.println(date);
        if (date != null) {
            DefaultTableModel model = (DefaultTableModel) tablethongkedoanhthu.getModel();
            model.setRowCount(0);
            List<HoaDon> list = daohd.selectThongkeHoaDon((int) date);
            try {
                for (HoaDon hoaDon : list) {
                    Object[] row = {hoaDon.getMaHD(), hoaDon.getMaKH(), hoaDon.getMaNV(), hoaDon.getNgayDatHang(), hoaDon.getMaBan(), hoaDon.getThanhTien(), hoaDon.getTrangThai()?"Đã thanh toán":"Chưa thanh toán"};
                    model.addRow(row);
                }
            } catch (Exception e) {
                DialogHelper.alert(this, "Lỗi fill table thongke");
                System.out.println(e);
            }
        }

    }

    void filltableThongkeHoaDonjdate() {
        Date date = jdate.getDate();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        if (localDate != null) {
            System.out.println(localDate);
            DefaultTableModel model = (DefaultTableModel) tablethongkedoanhthu.getModel();
            model.setRowCount(0);
            List<HoaDon> list = daohd.selectThongkeHoaDonjdate(localDate);
            try {
                for (HoaDon hoaDon : list) {
                    Object[] row = {hoaDon.getMaHD(), hoaDon.getMaKH(), hoaDon.getMaNV(), hoaDon.getNgayDatHang(), hoaDon.getMaBan(), hoaDon.getThanhTien(), hoaDon.getThanhTien()};
                    model.addRow(row);
                }
            } catch (Exception e) {
                DialogHelper.alert(this, "Lỗi fill table thongke");
                System.out.println(e);
            }
        }
    }

    private static CategoryDataset createDataset(ResultSet resultSet) throws SQLException {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Thêm dữ liệu từ ResultSet vào dataset
        while (resultSet.next()) {
            int month = resultSet.getInt("Thang");
            double totalRevenue = resultSet.getDouble("DoanhThu");
            dataset.addValue(totalRevenue, "DoanhThu", String.valueOf(month));
        }

        return dataset;
    }

    void fillChart() {
        Object date = cbbNam.getSelectedItem();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Kết nối đến CSDL MySQL (đảm bảo thay thế các giá trị đúng cho máy chủ, tên cơ sở dữ liệu, và thông tin xác thực)
            String url = "jdbc:sqlserver://localhost;database=DuanCoffee";
            String username = "sa";
            String password = "123456";
            Connection connection = DriverManager.getConnection(url, username, password);
            // Thực hiện truy vấn SQL
            String sqlQuery = "select MONTH(ngaydonhang) as 'Thang',sum(thanhtien) as 'DoanhThu' from hoadon where YEAR(ngaydonhang) = ? group by MONTH(ngaydonhang)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
                preparedStatement.setInt(1, (int) date);
                ResultSet resultSet = preparedStatement.executeQuery();
                // Xử lý kết quả truy vấn và tạo biểu đồ
                CategoryDataset dataset = createDataset(resultSet);
                JFreeChart chart = ChartFactory.createLineChart("Line char", "Tháng", "Doanh thu", dataset, PlotOrientation.VERTICAL,
                        true,
                        true,
                        false);
                BarRenderer render = null;
                CategoryPlot plot = null;
                render = new BarRenderer();
                ChartFrame frame = new ChartFrame("line chart", chart);
                frame.setSize(750, 470);
                frame.setVisible(true);
                frame.setLocationRelativeTo(this);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}