/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import dao.AlunoDAOJDBC;
import dao.CoordenadorDAOJDBC;
import dao.UsuarioDAOJDBC;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import modelo.Aluno;
import modelo.AlunoHasDisciplina;
import modelo.Disciplina;
import modelo.Usuario;
import static visao.TelaLoginController.usuario;

/**
 * FXML Controller class
 *
 * @author Leandro
 */
public class TelaCoordenadorController implements Initializable {

    @FXML
    private Button btn_dados_coord;
    @FXML
    private Button btn_matricular_aluno;
    @FXML
    private Label lb_nome;
    @FXML
    private Label lb_email;
    @FXML
    private Label lb_nascimento;
    @FXML
    private Label lb_telefone;
    @FXML
    private TextField txt_buscar_matricula;
    @FXML
    private TableView<Aluno> tb_dados_aluno;
    @FXML
    private TableColumn<Aluno, Integer> col_id_aluno;
    @FXML
    private TableColumn<Aluno, String> col_matricula_aluno;
    @FXML
    private TableColumn<Aluno, String> col_nome_aluno;
    @FXML
    private TableView<Disciplina> tb_disciplinas_aluno;
    @FXML
    private TableColumn<Disciplina, Integer> col_id_disciplina;
    @FXML
    private TableColumn<Disciplina, String> col_nome_disciplina;
    @FXML
    private TableColumn<Disciplina, String> col_professor_disciplina;
    @FXML
    private Button btn_buscar_matricula;
    @FXML
    private ComboBox<String> cb_disciplinas;
    @FXML
    private Button btn_finalizar;
    @FXML
    private Button btn_cancelar;
    @FXML
    private AnchorPane pane_matricula;
    @FXML
    private AnchorPane pane_dados;
    @FXML
    private Label lb_matricula;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
        UsuarioDAOJDBC jdbcUser = new UsuarioDAOJDBC();
        Usuario user = jdbcUser.buscarUsuario(usuario.getIdUser());
        
        //user = UsuarioDAOJDBC.buscarUser();
        lb_nome.setText(user.getNome());
        lb_matricula.setText(user.getMatricula());
        lb_nascimento.setText(user.getDataNascimento());
        lb_email.setText(user.getEmail());
        lb_telefone.setText(user.getTelefone());
  
        
        CoordenadorDAOJDBC coordenador = new CoordenadorDAOJDBC();
     
        cb_disciplinas.setItems(FXCollections.observableArrayList(coordenador.retornarDisciplinas()));
    
        btn_buscar_matricula.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
                CoordenadorDAOJDBC coordenador = new CoordenadorDAOJDBC();
                
                if(coordenador.buscarMatriculaAluno(txt_buscar_matricula.getText()) == null){
                    JOptionPane.showMessageDialog(null, "Matricula não encontrada");
          
                }else{
                    //JOptionPane.showMessageDialog(null, "Matricula encontrada");
                    col_id_aluno.setCellValueFactory(new PropertyValueFactory("idAluno"));
                    col_matricula_aluno.setCellValueFactory(new PropertyValueFactory("Matricula"));
                    col_nome_aluno.setCellValueFactory(new PropertyValueFactory("Nome"));
                    tb_dados_aluno.setItems(FXCollections.observableArrayList(coordenador.popularTabela(txt_buscar_matricula.getText())));
                    
                    
                    col_id_disciplina.setCellValueFactory(new PropertyValueFactory("idDisciplina"));
                    col_nome_disciplina.setCellValueFactory(new PropertyValueFactory("Nome"));
                    //col_professor_disciplina.setCellValueFactory(new PropertyValueFactory("Nome"));
                    tb_disciplinas_aluno.setItems(FXCollections.observableArrayList(coordenador.popularTabelaDisciplinas(coordenador.buscarMatriculaAluno(txt_buscar_matricula.getText()).getIdAluno())));
                }
       
            }
      
        });
        
        btn_finalizar.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
                
                int idDisc = coordenador.retornarIdDisciplina(cb_disciplinas.getSelectionModel().getSelectedItem());
                int idAlu = coordenador.retornarIdAluno(txt_buscar_matricula.getText());
                coordenador.matricularAluno(idDisc, idAlu);
                JOptionPane.showMessageDialog(null, "Aluno matriculado com sucesso!");
            }
        
        });
        
        btn_dados_coord.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
                pane_dados.toFront();
            }
            
            
        });
        
        btn_matricular_aluno.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
                pane_matricula.toFront();
            }
            
            
        });
        
      
       
    }    
    
}
