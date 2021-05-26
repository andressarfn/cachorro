package model;

import java.util.Random;

public class Cachorro {
	private String nome;
	private String raca;
	private String sexo;
	private float idade;
	private float energia = 100;
	private int num_filhotes = 0;
	
	
	public Cachorro(String nome, String raca, String sexo, float idade) {
		this.nome = nome;
		this.raca = raca;
		this.sexo = sexo;
		this.idade = idade;
	
	}
	
	public Cachorro () {}
	
	//MÉTODOS
	public String toString() {
		return   "\n\tNOME: "+this.nome+
				 "\n\tRAÇA: "+this.raca+
				 "\n\tSEXO: "+this.sexo+
				 "\n\tIDADE: "+this.idade+
				 "\n\tENERGIA: "+this.energia+
				 "\n\tFILHOTES: "+this.num_filhotes + "\n";
				
	}
	
	public float comer(String comida) {
	
		
		switch(comida) {
		case "R":
			return setEnergia(getEnergia() + 50);
		case "C":
			return setEnergia(getEnergia() + 40);
		case "L":
			return setEnergia(getEnergia() + 30);
		}
		return this.energia;
		
	}
	
	public float brincar(String brincadeira) {

		switch(brincadeira) {
		case "B":
			return setEnergia(getEnergia() - 30);
		case "S":
			return setEnergia(getEnergia() - 20);
		case "G":
			return setEnergia(getEnergia() - 10);
		}
		return this.energia;

	}
	
	public boolean pode_cruzar(Cachorro parceiro) {
		
		boolean checkIdade1 = false;
		boolean checkIdade2 = false;
		boolean checkRaca = false;
		boolean checkEnergia = false;
		boolean checkSexo = false;
		
		if (parceiro.getIdade() >= 1 && parceiro.getIdade() <= 9 ) 
			checkIdade1 = true;
		
		if (getIdade() >= 1 && getIdade() <= 9)
			checkIdade2 = true;
		
		if (parceiro.getRaca().equals(getRaca()))
			checkRaca = true;
		
		if (parceiro.getEnergia() > 80 && getEnergia() > 80)
			checkEnergia = true;
		
		if (parceiro.getSexo() != getSexo()) 
			checkSexo = true;
		
		if (checkIdade1 && checkIdade2 && checkRaca && checkEnergia && checkSexo) {
			return true;
		} else {
			return false;
		}

	}
	public int cruzar(Cachorro parceiro) {
		if (parceiro.pode_cruzar(parceiro) == true)
			parceiro.setEnergia((int) (parceiro.getEnergia() - 50));
			this.energia = (int) (getEnergia() - 50);
		
			Random random = new Random();
			int filhotes = random.nextInt((10 - 3) + 1) + 3;
			parceiro.setNum_filhotes((int) filhotes);
			this.num_filhotes = ((int) filhotes);
			return filhotes;
	}
		




	//GETTERS AND SETTERS
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRaca() {
		return this.raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public String getSexo() {
		return this.sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public float getIdade() {
		return this.idade;
	}
	public void setIdade(float idade) {
		this.idade = idade;
	}
	public float getEnergia() {
		return this.energia;
	}
	public float setEnergia(float energia) {
		return this.energia = energia;
	}
	public int getNum_filhotes() {
		return num_filhotes;
	}
	public void setNum_filhotes(int filhotes) {
		this.num_filhotes = filhotes;
	}
}
