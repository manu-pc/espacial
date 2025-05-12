/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import aplicacion.Usuario;
import aplicacion.Aficionado;
import aplicacion.Administrador;
import aplicacion.Estudiante;
import aplicacion.Cientifico;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.Component;
/**
 *
 * @author alumnogreibd
 */
public class VUsuario extends javax.swing.JDialog {
    private VPrincipal padre;
    private aplicacion.FachadaAplicacion fa;
    private Usuario miUsuario = null;
    private boolean avisado = false;
    private boolean modoRegistrar = false;

    /**
     * Creates new form VUsuario
     */
    public VUsuario(java.awt.Frame padre, boolean modal, aplicacion.FachadaAplicacion fa, boolean registrar) {
        super(padre, modal);
        this.fa = fa;
        initComponents();
        if (!registrar){
        cargarUsuarios();

        tablaUsuarios_af.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            // seleccionar primeira fila por defecto

            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    actualizarCampos();
                }
            }
        });        tablaUsuarios_ci.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            // seleccionar primeira fila por defecto

            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    actualizarCampos();
                }
            }
        });        tablaUsuarios_ad.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            // seleccionar primeira fila por defecto

            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    actualizarCampos();
                }
            }
        });        tablaUsuarios_es.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            // seleccionar primeira fila por defecto

            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    actualizarCampos();
                }
            }
        });}
        else {
            this.modoRegistrar = true;
            this.setTitle("Registro de usuario");
            this.setSize(731, 250);
            // se se creou unha ventana do tipo 'registrar usuario', non se poden ver os usuarios da tabla
            panelBuscaAf.setVisible(false);
            panelBuscaAd.setVisible(false);
            panelBuscaEs.setVisible(false);
            panelBuscaCi.setVisible(false);
            
            panelTablaAf.setVisible(false);
            panelTablaAd.setVisible(false);
            panelTablaEs.setVisible(false);
            panelTablaCi.setVisible(false);
            
            
            botonBorrar_af.setVisible(false);
            botonBorrar_ad.setVisible(false);
            botonBorrar_ci.setVisible(false);
            botonBorrar_es.setVisible(false);
            
            botonColaboracion.setVisible(false); // teño que supoñer que esto levaría a problemas con un usuario en proceso de crear
            
            jTabbedPane1.remove(1); // e evidentemente non podes registrarte como administrador. para ter cuenta de admin ten que darcha un admin

            // para evitar que cerrando a ventana de 'registrar' o usuario se salte a autenticacion
            this.setDefaultCloseOperation(javax.swing.JDialog.DISPOSE_ON_CLOSE);
            
            

            

            
        }
        
        
    }
    
public VUsuario(java.awt.Frame padre, boolean modal, aplicacion.FachadaAplicacion fa, Usuario miUsuario){
    super(padre, modal);
    this.fa = fa;
    this.miUsuario = miUsuario;
    initComponents();

    if (this.miUsuario != null){
        
        Component panel;
        if (miUsuario instanceof Aficionado){
            
            botonNuevo_af.setVisible(false);
            etiqueta_id_af.setVisible(false);
            campo_id_af.setVisible(false);
            boton_buscar_af.setVisible(false);
             panel = jTabbedPane1.getComponentAt(0);
        }
        else if (miUsuario instanceof Administrador){
                        botonNuevo_ad.setVisible(false);
            etiqueta_id_ad.setVisible(false);
            campo_id_ad.setVisible(false);
            boton_buscar_ad.setVisible(false);
             panel = jTabbedPane1.getComponentAt(1);
        }
        else if (miUsuario instanceof Estudiante){
                        botonNuevo_es.setVisible(false);
            etiqueta_id_es.setVisible(false);
            campo_id_es.setVisible(false);
            boton_buscar_es.setVisible(false);
             panel = jTabbedPane1.getComponentAt(2);
        }
        else {
                        botonNuevo5.setVisible(false);
           etiqueta_id_ci.setVisible(false);
            campo_id_ci.setVisible(false);
            boton_buscar_ci.setVisible(false);
                        panel = jTabbedPane1.getComponentAt(3);
        }

        jTabbedPane1.removeAll();
        jTabbedPane1.add(panel);
    }

    cargarUsuarios();

    tablaUsuarios_af.getSelectionModel().addListSelectionListener(event -> {
        if (!event.getValueIsAdjusting()) {
            actualizarCampos();
        }
    });
    tablaUsuarios_ci.getSelectionModel().addListSelectionListener(event -> {
        if (!event.getValueIsAdjusting()) {
            actualizarCampos();
        }
    });
    tablaUsuarios_ad.getSelectionModel().addListSelectionListener(event -> {
        if (!event.getValueIsAdjusting()) {
            actualizarCampos();
        }
    });
    tablaUsuarios_es.getSelectionModel().addListSelectionListener(event -> {
        if (!event.getValueIsAdjusting()) {
            actualizarCampos();
        }
    });
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        Aficionado = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        etiqueta_ed_nombre = new javax.swing.JLabel();
        etiqueta_ed_id = new javax.swing.JLabel();
        campo_ed_id_af = new javax.swing.JTextField();
        etiqueta_ed_clave = new javax.swing.JLabel();
        etiqueta_ed_email = new javax.swing.JLabel();
        campo_ed_email_af = new javax.swing.JTextField();
        etiqueta_ed_tipo = new javax.swing.JLabel();
        campo_ed_nombre_af = new javax.swing.JTextField();
        selec_ed_tier_af = new javax.swing.JComboBox<>();
        campo_ed_clave_af = new javax.swing.JPasswordField();
        botonNuevo_af = new javax.swing.JButton();
        botonGuardar_af = new javax.swing.JButton();
        botonBorrar_af = new javax.swing.JButton();
        botonSalir_af = new javax.swing.JButton();
        panelTablaAf = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios_af = new javax.swing.JTable();
        panelBuscaAf = new javax.swing.JPanel();
        etiqueta_id_af = new javax.swing.JLabel();
        campo_id_af = new javax.swing.JTextField();
        boton_buscar_af = new javax.swing.JButton();
        Administradores = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        etiqueta_ed_nombre3 = new javax.swing.JLabel();
        etiqueta_ed_id3 = new javax.swing.JLabel();
        campo_ed_id_ad = new javax.swing.JTextField();
        etiqueta_ed_clave3 = new javax.swing.JLabel();
        etiqueta_ed_email3 = new javax.swing.JLabel();
        campo_ed_email_ad = new javax.swing.JTextField();
        etiqueta_ed_tipo3 = new javax.swing.JLabel();
        campo_ed_nombre_ad = new javax.swing.JTextField();
        selec_ed_tier_ad = new javax.swing.JComboBox<>();
        campo_ed_clave_ad = new javax.swing.JPasswordField();
        botonNuevo_ad = new javax.swing.JButton();
        botonGuardar_ad = new javax.swing.JButton();
        botonBorrar_ad = new javax.swing.JButton();
        botonSalir_ad = new javax.swing.JButton();
        panelTablaAd = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaUsuarios_ad = new javax.swing.JTable();
        panelBuscaAd = new javax.swing.JPanel();
        etiqueta_id_ad = new javax.swing.JLabel();
        campo_id_ad = new javax.swing.JTextField();
        boton_buscar_ad = new javax.swing.JButton();
        Estudiantes = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        etiqueta_ed_nombre4 = new javax.swing.JLabel();
        etiqueta_ed_id4 = new javax.swing.JLabel();
        campo_ed_id_es = new javax.swing.JTextField();
        etiqueta_ed_clave4 = new javax.swing.JLabel();
        etiqueta_ed_email4 = new javax.swing.JLabel();
        campo_ed_email_es = new javax.swing.JTextField();
        campo_ed_nombre_es = new javax.swing.JTextField();
        etiqueta_ed_tipo6 = new javax.swing.JLabel();
        campo_ed_num_es = new javax.swing.JTextField();
        etiqueta_ed_clave1 = new javax.swing.JLabel();
        campo_ed_centro_es = new javax.swing.JTextField();
        campo_ed_clave_es = new javax.swing.JPasswordField();
        botonNuevo_es = new javax.swing.JButton();
        botonGuardar_es = new javax.swing.JButton();
        botonBorrar_es = new javax.swing.JButton();
        botonSalir_es = new javax.swing.JButton();
        panelTablaEs = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaUsuarios_es = new javax.swing.JTable();
        panelBuscaEs = new javax.swing.JPanel();
        etiqueta_id_es = new javax.swing.JLabel();
        campo_id_es = new javax.swing.JTextField();
        boton_buscar_es = new javax.swing.JButton();
        Científicos = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        etiqueta_ed_nombre5 = new javax.swing.JLabel();
        etiqueta_ed_id5 = new javax.swing.JLabel();
        campo_ed_id_ci = new javax.swing.JTextField();
        etiqueta_ed_clave5 = new javax.swing.JLabel();
        etiqueta_ed_email5 = new javax.swing.JLabel();
        campo_ed_email_ci = new javax.swing.JTextField();
        campo_ed_nombre_ci = new javax.swing.JTextField();
        etiqueta_ed_clave2 = new javax.swing.JLabel();
        campo_ed_centro_ci = new javax.swing.JTextField();
        campo_ed_clave_ci = new javax.swing.JPasswordField();
        botonColaboracion = new javax.swing.JButton();
        botonNuevo5 = new javax.swing.JButton();
        botonGuardar5 = new javax.swing.JButton();
        botonBorrar_ci = new javax.swing.JButton();
        botonSalir5 = new javax.swing.JButton();
        panelTablaCi = new javax.swing.JPanel();
        panelTabla = new javax.swing.JScrollPane();
        tablaUsuarios_ci = new javax.swing.JTable();
        panelBuscaCi = new javax.swing.JPanel();
        etiqueta_id_ci = new javax.swing.JLabel();
        campo_id_ci = new javax.swing.JTextField();
        boton_buscar_ci = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de usuarios");

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        etiqueta_ed_nombre.setText("Nombre");

        etiqueta_ed_id.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        etiqueta_ed_id.setText("ID");

        etiqueta_ed_clave.setText(" Clave");

        etiqueta_ed_email.setText("E-mail");

        etiqueta_ed_tipo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        etiqueta_ed_tipo.setText("Tier");

        selec_ed_tier_af.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Principiante", "Intermedio", "Avanzado" }));
        selec_ed_tier_af.setToolTipText("");
        selec_ed_tier_af.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selec_ed_tier_afActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(etiqueta_ed_id)
                    .addComponent(etiqueta_ed_nombre))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campo_ed_nombre_af, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campo_ed_id_af, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(etiqueta_ed_email))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(etiqueta_ed_clave)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(campo_ed_clave_af, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(etiqueta_ed_tipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selec_ed_tier_af, 0, 292, Short.MAX_VALUE))
                    .addComponent(campo_ed_email_af))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqueta_ed_clave)
                    .addComponent(etiqueta_ed_tipo)
                    .addComponent(campo_ed_id_af, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiqueta_ed_id)
                    .addComponent(selec_ed_tier_af, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campo_ed_clave_af, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqueta_ed_nombre)
                    .addComponent(etiqueta_ed_email)
                    .addComponent(campo_ed_email_af, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campo_ed_nombre_af, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        botonNuevo_af.setText("Nuevo");
        botonNuevo_af.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevo_afActionPerformed(evt);
            }
        });

        botonGuardar_af.setText("Guardar");
        botonGuardar_af.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardar_afActionPerformed(evt);
            }
        });

        botonBorrar_af.setText("Borrar");
        botonBorrar_af.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrar_afActionPerformed(evt);
            }
        });

        botonSalir_af.setText("Salir");
        botonSalir_af.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalir_afActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(botonNuevo_af)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonGuardar_af)
                        .addGap(12, 12, 12)
                        .addComponent(botonBorrar_af)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonSalir_af)))
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonNuevo_af)
                    .addComponent(botonGuardar_af)
                    .addComponent(botonBorrar_af)
                    .addComponent(botonSalir_af))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        tablaUsuarios_af.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "E-mail", "Tier"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaUsuarios_af);
        if (tablaUsuarios_af.getColumnModel().getColumnCount() > 0) {
            tablaUsuarios_af.getColumnModel().getColumn(0).setResizable(false);
            tablaUsuarios_af.getColumnModel().getColumn(1).setResizable(false);
            tablaUsuarios_af.getColumnModel().getColumn(2).setResizable(false);
            tablaUsuarios_af.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout panelTablaAfLayout = new javax.swing.GroupLayout(panelTablaAf);
        panelTablaAf.setLayout(panelTablaAfLayout);
        panelTablaAfLayout.setHorizontalGroup(
            panelTablaAfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
        );
        panelTablaAfLayout.setVerticalGroup(
            panelTablaAfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTablaAfLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        etiqueta_id_af.setText("ID:");

        boton_buscar_af.setText("Buscar");
        boton_buscar_af.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_buscar_afActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBuscaAfLayout = new javax.swing.GroupLayout(panelBuscaAf);
        panelBuscaAf.setLayout(panelBuscaAfLayout);
        panelBuscaAfLayout.setHorizontalGroup(
            panelBuscaAfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBuscaAfLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiqueta_id_af)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_id_af, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boton_buscar_af))
        );
        panelBuscaAfLayout.setVerticalGroup(
            panelBuscaAfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBuscaAfLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(panelBuscaAfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqueta_id_af)
                    .addComponent(campo_id_af, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton_buscar_af))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout AficionadoLayout = new javax.swing.GroupLayout(Aficionado);
        Aficionado.setLayout(AficionadoLayout);
        AficionadoLayout.setHorizontalGroup(
            AficionadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AficionadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBuscaAf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
            .addGroup(AficionadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AficionadoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(AficionadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AficionadoLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTablaAf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        AficionadoLayout.setVerticalGroup(
            AficionadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AficionadoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(panelBuscaAf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(411, Short.MAX_VALUE))
            .addGroup(AficionadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AficionadoLayout.createSequentialGroup()
                    .addGap(0, 328, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(AficionadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AficionadoLayout.createSequentialGroup()
                    .addGap(90, 90, 90)
                    .addComponent(panelTablaAf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(231, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Aficionados", Aficionado);

        etiqueta_ed_nombre3.setText("Nombre");

        etiqueta_ed_id3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        etiqueta_ed_id3.setText("ID");

        etiqueta_ed_clave3.setText(" Clave");

        etiqueta_ed_email3.setText("E-mail");

        etiqueta_ed_tipo3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        etiqueta_ed_tipo3.setText("Rango");

        selec_ed_tier_ad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Moderador", "Dueño" }));
        selec_ed_tier_ad.setToolTipText("");
        selec_ed_tier_ad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selec_ed_tier_adActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(etiqueta_ed_id3)
                    .addComponent(etiqueta_ed_nombre3))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campo_ed_nombre_ad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campo_ed_id_ad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(etiqueta_ed_email3))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(etiqueta_ed_clave3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(campo_ed_clave_ad, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(etiqueta_ed_tipo3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selec_ed_tier_ad, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(campo_ed_email_ad))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqueta_ed_clave3)
                    .addComponent(etiqueta_ed_tipo3)
                    .addComponent(campo_ed_id_ad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiqueta_ed_id3)
                    .addComponent(selec_ed_tier_ad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campo_ed_clave_ad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqueta_ed_nombre3)
                    .addComponent(etiqueta_ed_email3)
                    .addComponent(campo_ed_email_ad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campo_ed_nombre_ad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        botonNuevo_ad.setText("Nuevo");
        botonNuevo_ad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevo_adActionPerformed(evt);
            }
        });

        botonGuardar_ad.setText("Guardar");
        botonGuardar_ad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardar_adActionPerformed(evt);
            }
        });

        botonBorrar_ad.setText("Borrar");
        botonBorrar_ad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrar_adActionPerformed(evt);
            }
        });

        botonSalir_ad.setText("Salir");
        botonSalir_ad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalir_adActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(botonNuevo_ad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonGuardar_ad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonBorrar_ad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonSalir_ad)
                .addGap(26, 26, 26))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonNuevo_ad)
                    .addComponent(botonGuardar_ad)
                    .addComponent(botonBorrar_ad)
                    .addComponent(botonSalir_ad))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        tablaUsuarios_ad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "E-mail", "Rango"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tablaUsuarios_ad);
        if (tablaUsuarios_ad.getColumnModel().getColumnCount() > 0) {
            tablaUsuarios_ad.getColumnModel().getColumn(0).setResizable(false);
            tablaUsuarios_ad.getColumnModel().getColumn(0).setHeaderValue("ID");
            tablaUsuarios_ad.getColumnModel().getColumn(1).setResizable(false);
            tablaUsuarios_ad.getColumnModel().getColumn(1).setHeaderValue("Nombre");
            tablaUsuarios_ad.getColumnModel().getColumn(2).setResizable(false);
            tablaUsuarios_ad.getColumnModel().getColumn(2).setHeaderValue("E-mail");
            tablaUsuarios_ad.getColumnModel().getColumn(3).setResizable(false);
            tablaUsuarios_ad.getColumnModel().getColumn(3).setHeaderValue("Rango");
        }

        javax.swing.GroupLayout panelTablaAdLayout = new javax.swing.GroupLayout(panelTablaAd);
        panelTablaAd.setLayout(panelTablaAdLayout);
        panelTablaAdLayout.setHorizontalGroup(
            panelTablaAdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
        );
        panelTablaAdLayout.setVerticalGroup(
            panelTablaAdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTablaAdLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        etiqueta_id_ad.setText("ID:");

        boton_buscar_ad.setText("Buscar");
        boton_buscar_ad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_buscar_adActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBuscaAdLayout = new javax.swing.GroupLayout(panelBuscaAd);
        panelBuscaAd.setLayout(panelBuscaAdLayout);
        panelBuscaAdLayout.setHorizontalGroup(
            panelBuscaAdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBuscaAdLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiqueta_id_ad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_id_ad, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boton_buscar_ad))
        );
        panelBuscaAdLayout.setVerticalGroup(
            panelBuscaAdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBuscaAdLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(panelBuscaAdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqueta_id_ad)
                    .addComponent(campo_id_ad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton_buscar_ad))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout AdministradoresLayout = new javax.swing.GroupLayout(Administradores);
        Administradores.setLayout(AdministradoresLayout);
        AdministradoresLayout.setHorizontalGroup(
            AdministradoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdministradoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBuscaAd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
            .addGroup(AdministradoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AdministradoresLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(AdministradoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AdministradoresLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTablaAd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        AdministradoresLayout.setVerticalGroup(
            AdministradoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdministradoresLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(panelBuscaAd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(411, Short.MAX_VALUE))
            .addGroup(AdministradoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AdministradoresLayout.createSequentialGroup()
                    .addGap(0, 328, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(AdministradoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AdministradoresLayout.createSequentialGroup()
                    .addGap(90, 90, 90)
                    .addComponent(panelTablaAd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(231, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Administradores", Administradores);

        etiqueta_ed_nombre4.setText("Nombre");

        etiqueta_ed_id4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        etiqueta_ed_id4.setText("ID");

        etiqueta_ed_clave4.setText(" Clave");

        etiqueta_ed_email4.setText("E-mail");

        etiqueta_ed_tipo6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        etiqueta_ed_tipo6.setText("Nº est.");

        campo_ed_num_es.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_ed_num_esActionPerformed(evt);
            }
        });

        etiqueta_ed_clave1.setText("Centro");

        campo_ed_centro_es.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_ed_centro_esActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(etiqueta_ed_id4)
                    .addComponent(etiqueta_ed_nombre4))
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campo_ed_nombre_es, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campo_ed_id_es, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(etiqueta_ed_email4))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(etiqueta_ed_clave4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campo_ed_email_es, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                    .addComponent(campo_ed_clave_es))
                .addGap(17, 17, 17)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(etiqueta_ed_tipo6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiqueta_ed_clave1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(campo_ed_num_es, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                    .addComponent(campo_ed_centro_es))
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqueta_ed_clave4)
                    .addComponent(campo_ed_id_es, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiqueta_ed_id4)
                    .addComponent(etiqueta_ed_clave1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campo_ed_centro_es, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campo_ed_clave_es, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqueta_ed_nombre4)
                    .addComponent(etiqueta_ed_email4)
                    .addComponent(campo_ed_email_es, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campo_ed_nombre_es, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiqueta_ed_tipo6)
                    .addComponent(campo_ed_num_es, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        botonNuevo_es.setText("Nuevo");
        botonNuevo_es.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevo_esActionPerformed(evt);
            }
        });

        botonGuardar_es.setText("Guardar");
        botonGuardar_es.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardar_esActionPerformed(evt);
            }
        });

        botonBorrar_es.setText("Borrar");
        botonBorrar_es.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrar_esActionPerformed(evt);
            }
        });

        botonSalir_es.setText("Salir");
        botonSalir_es.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalir_esActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(botonNuevo_es)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonGuardar_es)
                        .addGap(12, 12, 12)
                        .addComponent(botonBorrar_es)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonSalir_es)))
                .addGap(0, 0, 0))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonNuevo_es)
                    .addComponent(botonGuardar_es)
                    .addComponent(botonBorrar_es)
                    .addComponent(botonSalir_es))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        tablaUsuarios_es.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "E-mail", "Centro"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tablaUsuarios_es);
        if (tablaUsuarios_es.getColumnModel().getColumnCount() > 0) {
            tablaUsuarios_es.getColumnModel().getColumn(0).setResizable(false);
            tablaUsuarios_es.getColumnModel().getColumn(1).setResizable(false);
            tablaUsuarios_es.getColumnModel().getColumn(2).setResizable(false);
            tablaUsuarios_es.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout panelTablaEsLayout = new javax.swing.GroupLayout(panelTablaEs);
        panelTablaEs.setLayout(panelTablaEsLayout);
        panelTablaEsLayout.setHorizontalGroup(
            panelTablaEsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaEsLayout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );
        panelTablaEsLayout.setVerticalGroup(
            panelTablaEsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaEsLayout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 44, Short.MAX_VALUE))
        );

        etiqueta_id_es.setText("ID:");

        boton_buscar_es.setText("Buscar");
        boton_buscar_es.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_buscar_esActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBuscaEsLayout = new javax.swing.GroupLayout(panelBuscaEs);
        panelBuscaEs.setLayout(panelBuscaEsLayout);
        panelBuscaEsLayout.setHorizontalGroup(
            panelBuscaEsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBuscaEsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiqueta_id_es)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_id_es, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boton_buscar_es))
        );
        panelBuscaEsLayout.setVerticalGroup(
            panelBuscaEsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBuscaEsLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(panelBuscaEsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqueta_id_es)
                    .addComponent(campo_id_es, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton_buscar_es))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout EstudiantesLayout = new javax.swing.GroupLayout(Estudiantes);
        Estudiantes.setLayout(EstudiantesLayout);
        EstudiantesLayout.setHorizontalGroup(
            EstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EstudiantesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EstudiantesLayout.createSequentialGroup()
                        .addComponent(panelBuscaEs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EstudiantesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(panelTablaEs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
            .addGroup(EstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(EstudiantesLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        EstudiantesLayout.setVerticalGroup(
            EstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EstudiantesLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(panelBuscaEs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelTablaEs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(179, Short.MAX_VALUE))
            .addGroup(EstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EstudiantesLayout.createSequentialGroup()
                    .addGap(0, 328, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTabbedPane1.addTab("Estudiantes", Estudiantes);

        etiqueta_ed_nombre5.setText("Nombre");

        etiqueta_ed_id5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        etiqueta_ed_id5.setText("ID");

        etiqueta_ed_clave5.setText(" Clave");

        etiqueta_ed_email5.setText("E-mail");

        etiqueta_ed_clave2.setText("Centro");

        campo_ed_centro_ci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_ed_centro_ciActionPerformed(evt);
            }
        });

        botonColaboracion.setText("Colaboraciones");
        botonColaboracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonColaboracionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(etiqueta_ed_id5)
                    .addComponent(etiqueta_ed_nombre5))
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campo_ed_nombre_ci, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campo_ed_id_ci, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(etiqueta_ed_email5))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(etiqueta_ed_clave5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campo_ed_email_ci, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                    .addComponent(campo_ed_clave_ci))
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(etiqueta_ed_clave2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campo_ed_centro_ci, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botonColaboracion, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqueta_ed_clave5)
                    .addComponent(campo_ed_id_ci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiqueta_ed_id5)
                    .addComponent(campo_ed_centro_ci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiqueta_ed_clave2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campo_ed_clave_ci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqueta_ed_nombre5)
                    .addComponent(etiqueta_ed_email5)
                    .addComponent(campo_ed_email_ci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campo_ed_nombre_ci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonColaboracion))
                .addContainerGap())
        );

        botonNuevo5.setText("Nuevo");
        botonNuevo5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevo5ActionPerformed(evt);
            }
        });

        botonGuardar5.setText("Guardar");
        botonGuardar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardar5ActionPerformed(evt);
            }
        });

        botonBorrar_ci.setText("Borrar");
        botonBorrar_ci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrar_ciActionPerformed(evt);
            }
        });

        botonSalir5.setText("Salir");
        botonSalir5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalir5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(botonNuevo5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonGuardar5)
                        .addGap(12, 12, 12)
                        .addComponent(botonBorrar_ci)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonSalir5)))
                .addGap(0, 0, 0))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonNuevo5)
                    .addComponent(botonGuardar5)
                    .addComponent(botonBorrar_ci)
                    .addComponent(botonSalir5))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        tablaUsuarios_ci.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "E-mail", "Nº artículos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        panelTabla.setViewportView(tablaUsuarios_ci);
        if (tablaUsuarios_ci.getColumnModel().getColumnCount() > 0) {
            tablaUsuarios_ci.getColumnModel().getColumn(0).setResizable(false);
            tablaUsuarios_ci.getColumnModel().getColumn(1).setResizable(false);
            tablaUsuarios_ci.getColumnModel().getColumn(2).setResizable(false);
            tablaUsuarios_ci.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout panelTablaCiLayout = new javax.swing.GroupLayout(panelTablaCi);
        panelTablaCi.setLayout(panelTablaCiLayout);
        panelTablaCiLayout.setHorizontalGroup(
            panelTablaCiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
        );
        panelTablaCiLayout.setVerticalGroup(
            panelTablaCiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTablaCiLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        etiqueta_id_ci.setText("ID:");

        boton_buscar_ci.setText("Buscar");
        boton_buscar_ci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_buscar_ciActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBuscaCiLayout = new javax.swing.GroupLayout(panelBuscaCi);
        panelBuscaCi.setLayout(panelBuscaCiLayout);
        panelBuscaCiLayout.setHorizontalGroup(
            panelBuscaCiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBuscaCiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiqueta_id_ci)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_id_ci, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boton_buscar_ci))
        );
        panelBuscaCiLayout.setVerticalGroup(
            panelBuscaCiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBuscaCiLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(panelBuscaCiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqueta_id_ci)
                    .addComponent(campo_id_ci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton_buscar_ci))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout CientíficosLayout = new javax.swing.GroupLayout(Científicos);
        Científicos.setLayout(CientíficosLayout);
        CientíficosLayout.setHorizontalGroup(
            CientíficosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CientíficosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBuscaCi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
            .addGroup(CientíficosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(CientíficosLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(CientíficosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CientíficosLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTablaCi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        CientíficosLayout.setVerticalGroup(
            CientíficosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CientíficosLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(panelBuscaCi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(411, Short.MAX_VALUE))
            .addGroup(CientíficosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CientíficosLayout.createSequentialGroup()
                    .addGap(0, 328, Short.MAX_VALUE)
                    .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(CientíficosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(CientíficosLayout.createSequentialGroup()
                    .addGap(90, 90, 90)
                    .addComponent(panelTablaCi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(231, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Científicos", Científicos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        cargarUsuarios();

    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void botonNuevo_esActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevo_esActionPerformed
       vaciarCampos();
    }//GEN-LAST:event_botonNuevo_esActionPerformed

    private void botonNuevo_adActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevo_adActionPerformed
       vaciarCampos();
    }//GEN-LAST:event_botonNuevo_adActionPerformed

    private void botonNuevo_afActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevo_afActionPerformed
       vaciarCampos();
    }//GEN-LAST:event_botonNuevo_afActionPerformed

    private void botonNuevo5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevo5ActionPerformed
       vaciarCampos();
    }//GEN-LAST:event_botonNuevo5ActionPerformed

    
    private void guardarUsuario(
    javax.swing.JTable tabla,
    String id,
    String clave,
    String nombre,
    String email,
    String campoExtra1,  // puede ser centro o tier, según el tipo
    String campoExtra2,  // solo se usa para estudiante: num_est
    String tipoUsuario    // "Estudiante", "Aficionado", etc.
) {
    int fila = tabla.getSelectedRow();
    String id_previo = null;
    if (fila != -1) {
        id_previo = (String) tabla.getModel().getValueAt(fila, 0);
    }

    if (id.isEmpty() || nombre.isEmpty() || email.isEmpty() || campoExtra1.isEmpty()) {
        fa.muestraExcepcion("Por favor, complete todos os campos.");
        return;
    }

    // Validación especial para estudiantes
    int num_est = -1;
    if ("Estudiante".equals(tipoUsuario)) {
        try {
            num_est = Integer.parseInt(campoExtra2);
        } catch (NumberFormatException e) {
            fa.muestraExcepcion("El número_estudante debe ser un valor numérico.");
            return;
        }
    }

    if (fila == -1) { // Crear
        if (clave.isEmpty()) {
            fa.muestraExcepcion("Debe escribir la clave del nuevo usuario.");
            return;
        }
        switch (tipoUsuario) {
            case "Estudiante":
                fa.crearEstudiante(id, clave, nombre, email, campoExtra1, num_est);
                break;
            case "Aficionado":
                fa.crearAficionado(id, clave, nombre, email, campoExtra1);
                break;
            case "Administrador":
                fa.crearAdministrador(id, clave, nombre, email, campoExtra1);
                break;
            case "Cientifico":
                fa.crearCientifico(id, clave, nombre, email, campoExtra1);
                break;
        }
    } else { // Modificar
        switch (tipoUsuario) {
            case "Estudiante":
                fa.modificarEstudiante(id_previo, id, clave, nombre, email, campoExtra1, num_est);
                break;
            case "Aficionado":
                fa.modificarAficionado(id_previo, id, clave, nombre, email, campoExtra1);
                break;
            case "Administrador":
                fa.modificarAdministrador(id_previo, id, clave, nombre, email, campoExtra1);
                break;
            case "Cientifico":
                fa.modificarCientifico(id_previo, id, clave, nombre, email, campoExtra1);
                break;
        }
        if (miUsuario != null && !id_previo.equals(id)) {
            fa.muestraExcepcion("Ha modificado su id. Por seguridad, vuelva a iniciar sesión.");
            this.dispose();
            fa.iniciaInterfazUsuario();
            return;
        }
    }

    if (!modoRegistrar) cargarUsuarios();
    else {
        fa.muestraMensaje("Ha creado su cuenta! Por favor, inicie sesión con sus nuevas credenciales.");
        this.dispose();
    }
}

    private void botonGuardar_esActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardar_esActionPerformed
     guardarUsuario(
        tablaUsuarios_es,
        campo_ed_id_es.getText().trim(),
        campo_ed_clave_es.getText().trim(),
        campo_ed_nombre_es.getText().trim(),
        campo_ed_email_es.getText().trim(),
        campo_ed_centro_es.getText().trim(),
        campo_ed_num_es.getText().trim(),
        "Estudiante"
    );
    }//GEN-LAST:event_botonGuardar_esActionPerformed

    private void botonGuardar_afActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardar_afActionPerformed
    guardarUsuario(
        tablaUsuarios_af,
        campo_ed_id_af.getText().trim(),
        campo_ed_clave_af.getText().trim(),
        campo_ed_nombre_af.getText().trim(),
        campo_ed_email_af.getText().trim(),
        (String) selec_ed_tier_af.getSelectedItem(),
        "", // sobra neste tipo de usuario
        "Aficionado"
    );
    }//GEN-LAST:event_botonGuardar_afActionPerformed

    private void botonGuardar_adActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardar_adActionPerformed
    guardarUsuario(
        tablaUsuarios_ad,
        campo_ed_id_ad.getText().trim(),
        campo_ed_clave_ad.getText().trim(),
        campo_ed_nombre_ad.getText().trim(),
        campo_ed_email_ad.getText().trim(),
        (String) selec_ed_tier_ad.getSelectedItem(),
        "",  // sobra neste tipo de usuario
        "Administrador"
    );
    }//GEN-LAST:event_botonGuardar_adActionPerformed

    private void botonGuardar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardar5ActionPerformed
    guardarUsuario(
        tablaUsuarios_ci,
        campo_ed_id_ci.getText().trim(),
        campo_ed_clave_ci.getText().trim(),
        campo_ed_nombre_ci.getText().trim(),
        campo_ed_email_ci.getText().trim(),
        campo_ed_centro_ci.getText().trim(),
        "",  // sobra neste tipo de usuario
        
        "Cientifico"
    );
    }//GEN-LAST:event_botonGuardar5ActionPerformed


    private void borrarUsuarioPropio(String idUsuario){
        if (!avisado) {
            fa.muestraExcepcion("AVISO: Esto eliminará tu propia cuenta del sistema, cerrando el programa!\n Vuelva a seleccionar 'borrar' si está seguro.");
            avisado = true;
        }
        else {
            fa.borrarUsuario(idUsuario);
            fa.muestraExcepcion("Su cuenta ha sido eliminada.");
            this.dispose();
            System.exit(0);
        }
    }
    private void botonBorrar_adActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrar_adActionPerformed

        if (miUsuario!= null) {
            borrarUsuarioPropio(miUsuario.getIdUsuario());
            return;
        }
        String id = campo_ed_id_ad.getText().trim();
        if (id.isEmpty()){
            fa.muestraExcepcion("Introduzca el ID el usuario a borrar!");
            return;
        }
        fa.borrarUsuario(id);
        cargarUsuarios();

    }//GEN-LAST:event_botonBorrar_adActionPerformed

    private void botonBorrar_afActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrar_afActionPerformed
        
        if (miUsuario!= null) {
            borrarUsuarioPropio(miUsuario.getIdUsuario());
            return;
        }
        String id = campo_ed_id_af.getText().trim();
        if (id.isEmpty()){
            fa.muestraExcepcion("Introduzca el ID el usuario a borrar!");
            return;
        }
        fa.borrarUsuario(id);
            cargarUsuarios();
    }//GEN-LAST:event_botonBorrar_afActionPerformed

    private void botonBorrar_esActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrar_esActionPerformed
        
        if (miUsuario!= null) {
            borrarUsuarioPropio(miUsuario.getIdUsuario());
            return;
        }
        String id = campo_ed_id_es.getText().trim();
        if (id.isEmpty()){
            fa.muestraExcepcion("Introduzca el ID el usuario a borrar!");
            return;
        }
        fa.borrarUsuario(id);
            cargarUsuarios();
    }//GEN-LAST:event_botonBorrar_esActionPerformed

    private void botonBorrar_ciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrar_ciActionPerformed
        
        if (miUsuario!= null) {
            borrarUsuarioPropio(miUsuario.getIdUsuario());
            return;
        }
        String id = campo_ed_id_ci.getText().trim();
        if (id.isEmpty()){
            fa.muestraExcepcion("Introduzca el ID el usuario a borrar!");
            return;
        }
        fa.borrarUsuario(id);
            cargarUsuarios();
    }//GEN-LAST:event_botonBorrar_ciActionPerformed

    private void botonColaboracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonColaboracionActionPerformed
        int fila = tablaUsuarios_ci.getSelectedRow();
        if (fila == -1){
            fa.muestraExcepcion("Selecciona a un científico existente para agregarle colaboraciones");
        }
        else {
            ModeloTablaCientificos m = (ModeloTablaCientificos) tablaUsuarios_ci.getModel();
            Cientifico c = m.obtenerUsuario(fila);
            fa.abrirColaboraciones(c, this);
        }

    }//GEN-LAST:event_botonColaboracionActionPerformed

    private void boton_buscar_esActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_boton_buscar_esActionPerformed
        String id = campo_id_es.getText().trim();

        if (!id.isEmpty()) {
            buscarUsuarioPorId(id);
        } else {
            cargarUsuarios();
        }
    }// GEN-LAST:event_boton_buscar_esActionPerformed

    private void botonSalir_esActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botonSalir_esActionPerformed
        this.dispose();


    }// GEN-LAST:event_botonSalir_esActionPerformed
    private void campo_ed_centro_ciActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botonSalir_esActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_botonSalir_esActionPerformed

    private void campo_ed_num_esActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_campo_ed_num_esActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_campo_ed_num_esActionPerformed

    private void campo_ed_clave_esActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_campo_ed_clave_esActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_campo_ed_clave_esActionPerformed
    private void campo_ed_centro_esActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_campo_ed_clave_esActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_campo_ed_clave_esActionPerformed

    private void boton_buscar_adActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_boton_buscar_adActionPerformed
        String id = campo_id_ad.getText().trim();

        if (!id.isEmpty()) {
            buscarUsuarioPorId(id);
        } else {
            cargarUsuarios();
        }
    }// GEN-LAST:event_boton_buscar_adActionPerformed

    private void botonSalir_adActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botonSalir_adActionPerformed
        this.dispose();
  }// GEN-LAST:event_botonSalir_adActionPerformed

    private void selec_ed_tier_adActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_selec_ed_tier_adActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_selec_ed_tier_adActionPerformed

    private void campo_ed_clave_adActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_campo_ed_clave_adActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_campo_ed_clave_adActionPerformed

    private void boton_buscar_afActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_boton_buscar_afActionPerformed
        String id = campo_id_af.getText().trim();

        if (!id.isEmpty()) {
            buscarUsuarioPorId(id);
        } else {
            cargarUsuarios();
        }
    }// GEN-LAST:event_boton_buscar_afActionPerformed

    private void botonSalir_afActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botonSalir_afActionPerformed
        this.dispose();
     
        
    }// GEN-LAST:event_botonSalir_afActionPerformed

    private void selec_ed_tier_afActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_selec_ed_tier_afActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_selec_ed_tier_afActionPerformed

    private void campo_ed_clave_afActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_campo_ed_clave_afActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_campo_ed_clave_afActionPerformed

    private void campo_ed_clave_ciActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_campo_ed_clave_ciActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_campo_ed_clave_ciActionPerformed

    private void campo_ed_clave11ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_campo_ed_clave11ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_campo_ed_clave11ActionPerformed

    private void botonSalir5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botonSalir5ActionPerformed
        this.dispose();

    }// GEN-LAST:event_botonSalir5ActionPerformed

    private void boton_buscar_ciActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_boton_buscar_ciActionPerformed
        String id = campo_id_ci.getText().trim();

        if (!id.isEmpty()) {
            buscarUsuarioPorId(id);
        } else {
            cargarUsuarios();
        }
    }// GEN-LAST:event_boton_buscar_ciActionPerformed

    private void campo_ed_clave_af1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_campo_ed_clave_af1ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_campo_ed_clave_af1ActionPerformed

    private void campo_ed_clave_af2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_campo_ed_clave_af2ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_campo_ed_clave_af2ActionPerformed

    private void actualizarCampos() {

        int panel = jTabbedPane1.getSelectedIndex();
        
        switch (panel) {
            case 0:
                int selectedRow = tablaUsuarios_af.getSelectedRow();
                if (selectedRow > -1) { // hai unha fila seleccionada
                    ModeloTablaAficionados modelo = (ModeloTablaAficionados) tablaUsuarios_af.getModel();
                    Aficionado usuario = (Aficionado) modelo.obtenerUsuario(selectedRow);
                    if (usuario == null) {
                        vaciarCampos();
                        return;
                    }
                    campo_ed_id_af.setText(usuario.getIdUsuario());
                    campo_ed_clave_af.setText("");
                    campo_ed_nombre_af.setText(usuario.getNombre());
                    campo_ed_email_af.setText(usuario.getEmail());
                    break;
                }
            case 1:
                selectedRow = tablaUsuarios_ad.getSelectedRow();
                if (selectedRow > -1) { // hai unha fila seleccionada
                    ModeloTablaAdministradores modelo = (ModeloTablaAdministradores) tablaUsuarios_ad.getModel();
                    Administrador usuario = (Administrador) modelo.obtenerUsuario(selectedRow);
                    if (usuario == null) {
                        vaciarCampos();
                        return;
                    }
                    campo_ed_id_ad.setText(usuario.getIdUsuario());
                    campo_ed_clave_ad.setText("");
                    campo_ed_nombre_ad.setText(usuario.getNombre());
                    campo_ed_email_ad.setText(usuario.getEmail());
                    break;
                }
            case 3:
                selectedRow = tablaUsuarios_ci.getSelectedRow();
                if (selectedRow > -1) { // hai unha fila seleccionada
                    ModeloTablaCientificos modelo = (ModeloTablaCientificos) tablaUsuarios_ci.getModel();
                    Cientifico usuario = (Cientifico) modelo.obtenerUsuario(selectedRow);
                    if (usuario == null) {
                        vaciarCampos();
                        return;
                    }
                    campo_ed_id_ci.setText(usuario.getIdUsuario());
                    campo_ed_clave_ci.setText("");
                    campo_ed_nombre_ci.setText(usuario.getNombre());
                    campo_ed_email_ci.setText(usuario.getEmail());
                    campo_ed_centro_ci.setText(usuario.getCentro());
                    break;
                }
            case 2:
                selectedRow = tablaUsuarios_es.getSelectedRow();
                if (selectedRow > -1) { // hai unha fila seleccionada
                    ModeloTablaEstudiantes modelo = (ModeloTablaEstudiantes) tablaUsuarios_es.getModel();
                    Estudiante usuario = (Estudiante) modelo.obtenerUsuario(selectedRow);
                    if (usuario == null) {
                        vaciarCampos();
                        return;
                    }
                    campo_ed_id_es.setText(usuario.getIdUsuario());
                    campo_ed_clave_es.setText("");
                    campo_ed_nombre_es.setText(usuario.getNombre());
                    campo_ed_email_es.setText(usuario.getEmail());
                                        campo_ed_centro_es.setText(usuario.getCentro());
                    campo_ed_num_es.setText(usuario.getNumEst().toString());

                    break;
                }
        }

    }

    private void vaciarCampos() {

        campo_ed_id_af.setText("");
        campo_ed_clave_af.setText("");
        campo_ed_nombre_af.setText("");
        campo_ed_email_af.setText("");
        tablaUsuarios_af.clearSelection();
            
        campo_ed_id_ad.setText("");
        campo_ed_clave_ad.setText("");
        campo_ed_nombre_ad.setText("");
        campo_ed_email_ad.setText("");
        tablaUsuarios_ad.clearSelection();

        
        campo_ed_id_ci.setText("");
        campo_ed_clave_ci.setText("");
        campo_ed_nombre_ci.setText("");
        campo_ed_email_ci.setText("");
        campo_ed_centro_ci.setText("");
        tablaUsuarios_ci.clearSelection();

        
        
        campo_ed_id_es.setText("");
        campo_ed_clave_es.setText("");
        campo_ed_nombre_es.setText("");
        campo_ed_email_es.setText("");
        campo_ed_num_es.setText("");
        campo_ed_centro_es.setText("");
        tablaUsuarios_es.clearSelection();

        
    }
    
    private void cargarUsuario(){
        if(miUsuario instanceof Aficionado){
            ModeloTablaAficionados m = new ModeloTablaAficionados();
            Usuario u = fa.buscarUsuarioPorId(miUsuario.getIdUsuario());
            if (u != null) {
                m.añadirFilaVacia();
                m.setFilas(java.util.Collections.singletonList((Aficionado) u));
                tablaUsuarios_af.setModel(m);
                if (tablaUsuarios_af.getRowCount() > 0) {
                    tablaUsuarios_af.setRowSelectionInterval(0, 0);
                }
            }
        }
        else if (miUsuario instanceof Administrador){
            ModeloTablaAdministradores m = new ModeloTablaAdministradores();
            Usuario u = fa.buscarUsuarioPorId(miUsuario.getIdUsuario());
            if (u != null) {
                m.añadirFilaVacia();
                m.setFilas(java.util.Collections.singletonList((Administrador) u));
                tablaUsuarios_ad.setModel(m);
                if (tablaUsuarios_ad.getRowCount() > 0) {
                    tablaUsuarios_ad.setRowSelectionInterval(0, 0);
                }
            }
        }
        else if (miUsuario instanceof Cientifico){
            ModeloTablaCientificos m = new ModeloTablaCientificos();
            Usuario u = fa.buscarUsuarioPorId(miUsuario.getIdUsuario());
            if (u != null) {
                m.añadirFilaVacia();
                m.setFilas(java.util.Collections.singletonList((Cientifico) u));
                tablaUsuarios_ci.setModel(m);
                if (tablaUsuarios_ci.getRowCount() > 0) {
                    tablaUsuarios_ci.setRowSelectionInterval(0, 0);
                }
            }
        }
        else if (miUsuario instanceof Estudiante){
            ModeloTablaEstudiantes m = new ModeloTablaEstudiantes();
            Usuario u = fa.buscarUsuarioPorId(miUsuario.getIdUsuario());
            if (u != null) {
                m.añadirFilaVacia();
                m.setFilas(java.util.Collections.singletonList((Estudiante) u));
                tablaUsuarios_es.setModel(m);
                if (tablaUsuarios_es.getRowCount() > 0) {
                    tablaUsuarios_es.setRowSelectionInterval(0, 0);
                }
            }
        }
        else {
            fa.muestraExcepcion("¡Se ha producido un error! El ID del usuario actual no existe en la base de datos.");
        }
        actualizarCampos();
    }

    private void cargarUsuarios() {
        if (miUsuario != null) {
            cargarUsuario();
            return;
        }
        int panel = jTabbedPane1.getSelectedIndex();
        switch (panel) {
            case 0:
                ModeloTablaAficionados m = new ModeloTablaAficionados();
                java.util.List<Usuario> usuarios = fa.obtenerUsuarios();
                java.util.List<Aficionado> aficionados = new java.util.ArrayList<>();
                for (Usuario usuario : usuarios) {
                    if (usuario instanceof Aficionado) {
                        aficionados.add((Aficionado) usuario);
                    }
                }
                m.setFilas(aficionados);
                tablaUsuarios_af.setModel(m);
                break;
            case 1:
                ModeloTablaAdministradores m2 = new ModeloTablaAdministradores();
                java.util.List<Usuario> usuarios2 = fa.obtenerUsuarios();
                java.util.List<Administrador> administradores = new java.util.ArrayList<>();
                for (Usuario usuario : usuarios2) {
                    if (usuario instanceof Administrador) {
                        administradores.add((Administrador) usuario);
                    }
                }
                m2.setFilas(administradores);
                tablaUsuarios_ad.setModel(m2);
                break;
            case 3:
                ModeloTablaCientificos m3 = new ModeloTablaCientificos();
                java.util.List<Usuario> usuarios3 = fa.obtenerUsuarios();
                java.util.List<Cientifico> cientificos = new java.util.ArrayList<>();
                for (Usuario usuario : usuarios3) {
                    if (usuario instanceof Cientifico) {
                        cientificos.add((Cientifico) usuario);
                    }
                }
                m3.setFilas(cientificos);
                tablaUsuarios_ci.setModel(m3);
                break;
            case 2:
                ModeloTablaEstudiantes m4 = new ModeloTablaEstudiantes();
                java.util.List<Usuario> usuarios4 = fa.obtenerUsuarios();
                java.util.List<Estudiante> estudiantes = new java.util.ArrayList<>();
                for (Usuario usuario : usuarios4) {
                    if (usuario instanceof Estudiante) {
                        estudiantes.add((Estudiante) usuario);
                    }
                }
                m4.setFilas(estudiantes);
                tablaUsuarios_es.setModel(m4);
                break;
        }
    }

    private void buscarUsuarioPorId(String id) {
        Usuario u = fa.buscarUsuarioPorId(id);

        if (u != null) {
            if (u instanceof Aficionado) {
                jTabbedPane1.setSelectedIndex(0);
                ModeloTablaAficionados m = new ModeloTablaAficionados();
                m.añadirFilaVacia();
                m.setFilas(java.util.Collections.singletonList((Aficionado) u));
                tablaUsuarios_af.setModel(m);
            } else if (u instanceof Administrador) {
                                jTabbedPane1.setSelectedIndex(1);

                ModeloTablaAdministradores m = new ModeloTablaAdministradores();
                m.añadirFilaVacia();
                m.setFilas(java.util.Collections.singletonList((Administrador) u));
                tablaUsuarios_ad.setModel(m);
            } else if (u instanceof Cientifico) {
                                jTabbedPane1.setSelectedIndex(3);

                ModeloTablaCientificos m = new ModeloTablaCientificos();
                m.añadirFilaVacia();
                m.setFilas(java.util.Collections.singletonList((Cientifico) u));
                tablaUsuarios_ci.setModel(m);
            } else if (u instanceof Estudiante) {
                                jTabbedPane1.setSelectedIndex(2);

                ModeloTablaEstudiantes m = new ModeloTablaEstudiantes();
                m.añadirFilaVacia();
                m.setFilas(java.util.Collections.singletonList((Estudiante) u));
                tablaUsuarios_es.setModel(m);
            }
        } else {
            fa.muestraExcepcion("¡No existe un usuario con ese ID!");

        }
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Administradores;
    private javax.swing.JPanel Aficionado;
    private javax.swing.JPanel Científicos;
    private javax.swing.JPanel Estudiantes;
    private javax.swing.JButton botonBorrar_ad;
    private javax.swing.JButton botonBorrar_af;
    private javax.swing.JButton botonBorrar_ci;
    private javax.swing.JButton botonBorrar_es;
    private javax.swing.JButton botonColaboracion;
    private javax.swing.JButton botonGuardar5;
    private javax.swing.JButton botonGuardar_ad;
    private javax.swing.JButton botonGuardar_af;
    private javax.swing.JButton botonGuardar_es;
    private javax.swing.JButton botonNuevo5;
    private javax.swing.JButton botonNuevo_ad;
    private javax.swing.JButton botonNuevo_af;
    private javax.swing.JButton botonNuevo_es;
    private javax.swing.JButton botonSalir5;
    private javax.swing.JButton botonSalir_ad;
    private javax.swing.JButton botonSalir_af;
    private javax.swing.JButton botonSalir_es;
    private javax.swing.JButton boton_buscar_ad;
    private javax.swing.JButton boton_buscar_af;
    private javax.swing.JButton boton_buscar_ci;
    private javax.swing.JButton boton_buscar_es;
    private javax.swing.JTextField campo_ed_centro_ci;
    private javax.swing.JTextField campo_ed_centro_es;
    private javax.swing.JPasswordField campo_ed_clave_ad;
    private javax.swing.JPasswordField campo_ed_clave_af;
    private javax.swing.JPasswordField campo_ed_clave_ci;
    private javax.swing.JPasswordField campo_ed_clave_es;
    private javax.swing.JTextField campo_ed_email_ad;
    private javax.swing.JTextField campo_ed_email_af;
    private javax.swing.JTextField campo_ed_email_ci;
    private javax.swing.JTextField campo_ed_email_es;
    private javax.swing.JTextField campo_ed_id_ad;
    private javax.swing.JTextField campo_ed_id_af;
    private javax.swing.JTextField campo_ed_id_ci;
    private javax.swing.JTextField campo_ed_id_es;
    private javax.swing.JTextField campo_ed_nombre_ad;
    private javax.swing.JTextField campo_ed_nombre_af;
    private javax.swing.JTextField campo_ed_nombre_ci;
    private javax.swing.JTextField campo_ed_nombre_es;
    private javax.swing.JTextField campo_ed_num_es;
    private javax.swing.JTextField campo_id_ad;
    private javax.swing.JTextField campo_id_af;
    private javax.swing.JTextField campo_id_ci;
    private javax.swing.JTextField campo_id_es;
    private javax.swing.JLabel etiqueta_ed_clave;
    private javax.swing.JLabel etiqueta_ed_clave1;
    private javax.swing.JLabel etiqueta_ed_clave2;
    private javax.swing.JLabel etiqueta_ed_clave3;
    private javax.swing.JLabel etiqueta_ed_clave4;
    private javax.swing.JLabel etiqueta_ed_clave5;
    private javax.swing.JLabel etiqueta_ed_email;
    private javax.swing.JLabel etiqueta_ed_email3;
    private javax.swing.JLabel etiqueta_ed_email4;
    private javax.swing.JLabel etiqueta_ed_email5;
    private javax.swing.JLabel etiqueta_ed_id;
    private javax.swing.JLabel etiqueta_ed_id3;
    private javax.swing.JLabel etiqueta_ed_id4;
    private javax.swing.JLabel etiqueta_ed_id5;
    private javax.swing.JLabel etiqueta_ed_nombre;
    private javax.swing.JLabel etiqueta_ed_nombre3;
    private javax.swing.JLabel etiqueta_ed_nombre4;
    private javax.swing.JLabel etiqueta_ed_nombre5;
    private javax.swing.JLabel etiqueta_ed_tipo;
    private javax.swing.JLabel etiqueta_ed_tipo3;
    private javax.swing.JLabel etiqueta_ed_tipo6;
    private javax.swing.JLabel etiqueta_id_ad;
    private javax.swing.JLabel etiqueta_id_af;
    private javax.swing.JLabel etiqueta_id_ci;
    private javax.swing.JLabel etiqueta_id_es;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel panelBuscaAd;
    private javax.swing.JPanel panelBuscaAf;
    private javax.swing.JPanel panelBuscaCi;
    private javax.swing.JPanel panelBuscaEs;
    private javax.swing.JScrollPane panelTabla;
    private javax.swing.JPanel panelTablaAd;
    private javax.swing.JPanel panelTablaAf;
    private javax.swing.JPanel panelTablaCi;
    private javax.swing.JPanel panelTablaEs;
    private javax.swing.JComboBox<String> selec_ed_tier_ad;
    private javax.swing.JComboBox<String> selec_ed_tier_af;
    private javax.swing.JTable tablaUsuarios_ad;
    private javax.swing.JTable tablaUsuarios_af;
    private javax.swing.JTable tablaUsuarios_ci;
    private javax.swing.JTable tablaUsuarios_es;
    // End of variables declaration//GEN-END:variables
}
