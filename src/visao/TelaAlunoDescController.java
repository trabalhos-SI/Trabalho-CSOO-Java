/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import static visao.TelaLoginController.usuario;
import dao.AlunoDAOJDBC;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import modelo.Aluno;
import modelo.AlunoHasDisciplina;
import modelo.Disciplina;

/**
 * FXML Controller class
 *
 * @author Leandro
 */
public class TelaAlunoDescController implements Initializable {
    
    @FXML
    private AnchorPane Tela_Disci;
    @FXML
    private Label lb_titulo;
    @FXML
    private AnchorPane Tela_Dados;
    @FXML
    private Label lb_tel;
    @FXML
    private Label lb_nome;
    @FXML
    private Label lb_curso;
    @FXML
    private Label lb_turma;
    @FXML
    private Label lb_matricula;
    @FXML
    private Label lb_data;
    @FXML
    private Label lb_email;
    @FXML
    private Button btn_dados;
    @FXML
    private Button btn_disciplina;
   
    @FXML
    private Label lbTeste1;
    @FXML
    private Label lbTeste11;
    @FXML
    private TableColumn<AlunoHasDisciplina, String> cl_disciplinaAluno;
    @FXML
    private TableColumn<AlunoHasDisciplina, Double> cl_prova1Aluno;
    @FXML
    private TableColumn<AlunoHasDisciplina, Double> cl_prova2Aluno;
    @FXML
    private TableColumn<Disciplina, Double> cl_mpAluno;
    @FXML
    private TableColumn<?, ?> cl_pfAluno;
    @FXML
    private TableColumn<AlunoHasDisciplina, Double> cl_mediaFinalAluno;
    @FXML
    private Label lb;
    @FXML
    private TableView<AlunoHasDisciplina> table;
    @FXML
    private TextField txt_nascimento;
    @FXML
    private TextField txt_email;
    @FXML
    private TextField txt_telefone;
    @FXML
    private Button btn_salvar_edit;
    @FXML
    private AnchorPane Tela_editar_dados;
    @FXML
    private Label lbTeste12;
    @FXML
    private TextField txt_nome;
    @FXML
    private TextField txt_curso;
    @FXML
    private TextField txt_turma;
    @FXML
    private TextField txt_matricula;
    @FXML
    private Button btn_editar_dados;
    @FXML
    private Button btn_cancelar;
  
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
       
    
    @Override
    @SuppressWarnings("empty-statement")
    public void initialize(URL url, ResourceBundle rb) {
        
        Aluno aluno;
        AlunoDAOJDBC alunojdbc;
        alunojdbc = new AlunoDAOJDBC();       
        aluno = alunojdbc.buscarAluno(usuario);
        
        lb_curso.setText(aluno.getCurso());
        lb_nome.setText(aluno.usuario.getNome());
        lb_turma.setText(aluno.getTurma());
        lb_matricula.setText(aluno.usuario.getMatricula());
        lb_data.setText(aluno.usuario.getDataNascimento());
        lb_email.setText(aluno.usuario.getEmail());
        lb_tel.setText(aluno.usuario.getTelefone());
    
        // LISTAR DISCIPLINAS DO ALUNO NO COMBOBOX
        cl_mediaFinalAluno.setCellValueFactory(new PropertyValueFactory("mediaFinal"));
        cl_mpAluno.setCellValueFactory(new PropertyValueFactory("mediaParcial"));
        cl_disciplinaAluno.setCellValueFactory(new PropertyValueFactory("DisciplinaNome"));
        cl_prova1Aluno.setCellValueFactory(new PropertyValueFactory("NotaProva1"));
        cl_prova2Aluno.setCellValueFactory(new PropertyValueFactory("NotaProva2"));
        cl_pfAluno.setCellValueFactory(new PropertyValueFactory("NotaProvaFinal"));
        table.setItems(FXCollections.observableArrayList(alunojdbc.listarDisciplina(aluno)));
        
        
        btn_dados.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
      
                Aluno aluno;
                AlunoDAOJDBC alunojdbc;
                alunojdbc = new AlunoDAOJDBC();       
                aluno = alunojdbc.buscarAluno(usuario);
        
                lb_curso.setText(aluno.getCurso());
                lb_nome.setText(aluno.usuario.getNome());
                lb_turma.setText(aluno.getTurma());
                lb_matricula.setText(aluno.usuario.getMatricula());
                lb_data.setText(aluno.usuario.getDataNascimento());
                lb_email.setText(aluno.usuario.getEmail());
                lb_tel.setText(aluno.usuario.getTelefone());
                Tela_Dados.toFront();
            }
  
        });
        
        btn_disciplina.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                Tela_Disci.toFront();
            }
        });
        
        btn_salvar_edit.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
               
                aluno.usuario.setNome(txt_nome.getText());
                aluno.setCurso(txt_curso.getText());
                aluno.setTurma(txt_turma.getText());
                aluno.setMatricula(txt_matricula.getText());
                aluno.setDataNascimento(txt_nascimento.getText());
                aluno.setEmail(txt_email.getText());
                aluno.setTelefone(txt_telefone.getText());
                alunojdbc.salvarAluno(aluno);
                
                Aluno aluno;
                AlunoDAOJDBC alunojdbc;
                alunojdbc = new AlunoDAOJDBC();       
                aluno = alunojdbc.buscarAluno(usuario);
                aluno = alunojdbc.buscarAluno(usuario);
        
                lb_curso.setText(aluno.getCurso());
                lb_nome.setText(aluno.usuario.getNome());
                lb_turma.setText(aluno.getTurma());
                lb_matricula.setText(aluno.usuario.getMatricula());
                lb_data.setText(aluno.usuario.getDataNascimento());
                lb_email.setText(aluno.usuario.getEmail());
                lb_tel.setText(aluno.usuario.getTelefone());
                Tela_Dados.toFront();
       
            }
  
        });
        
        btn_editar_dados.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
               
                Aluno aluno;
                AlunoDAOJDBC alunojdbc;
                alunojdbc = new AlunoDAOJDBC();       
                aluno = alunojdbc.buscarAluno(usuario);
                
                Tela_editar_dados.toFront();
                txt_nome.setText(aluno.usuario.getNome());
                txt_nome.setDisable(true);
                txt_curso.setText(aluno.getCurso());
                txt_curso.setDisable(true);
                txt_turma.setText(aluno.getTurma());
                txt_turma.setDisable(true);
                txt_matricula.setText(aluno.usuario.getMatricula());
                txt_matricula.setDisable(true);
                txt_nascimento.setText(aluno.usuario.getDataNascimento());
                txt_email.setText(aluno.usuario.getEmail());
                txt_telefone.setText(aluno.usuario.getTelefone());
             }
         });
        
        btn_cancelar.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                Tela_Dados.toFront();
            }
         });
       }//FIM DO INITIALIZE

}
