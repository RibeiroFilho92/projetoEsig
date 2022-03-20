package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import DAO.DAOGenerico;
import entidades.Atividade;

@ViewScoped
@ManagedBean(name = "atividadeBean")
public class AtividadeBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Atividade atividade = new Atividade();
	private DAOGenerico<Atividade> daoGenerico = new DAOGenerico<Atividade>();
	private List<Atividade> atividades = new ArrayList<Atividade>();

	public String salvar() {

		atividade = daoGenerico.merge(atividade);
		carregarAtividades();
		return "";
	}
	
	public String novo( ) {
		
		atividade = new Atividade();
		return "";
	}
	
	public String remover() {
		
		daoGenerico.deletarPorId(atividade);
		atividade = new Atividade();
		carregarAtividades();
		return "";
	}
	
	@PostConstruct
	public void carregarAtividades() {
		
		atividades = daoGenerico.getListEntity(Atividade.class);
		
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	public DAOGenerico<Atividade> getDaoGenerico() {
		return daoGenerico;
	}

	public void setDaoGenerico(DAOGenerico<Atividade> daoGenerico) {
		this.daoGenerico = daoGenerico;
	}

	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}
	
	

}
