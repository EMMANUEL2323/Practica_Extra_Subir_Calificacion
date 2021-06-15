package clases.ito.poo;

import Interfaces.ito.poo.Arregloo;

public class Composiciones implements Arregloo<Composicion> {
		private Composicion Cpo[]=null;
		private  int ultimo=0;
		private final int INC=5;
		public Composiciones() {
			super();
			this.Cpo = new Composicion[INC];
			this.ultimo = -1;
		}
		private void crecerArreglo() {
			Composicion temporal[]=new Composicion[this.Cpo.length+INC];
	    for(int i=0;i<this.Cpo.length;i++)	
	    Cpo=temporal;
	    }
		
		
		public boolean addItem(Composicion item) {
			
			boolean bandera=false;
			if(!existeIte(item)) {
				if(isFull())
					crecerArreglo();
				int i=0;
				for(;i<=this.ultimo;i++)
					if(item.compareTo(Cpo[i])<0) {
						break;
					}
				for(int j=this.ultimo;j>=i;j--)
					Cpo[j+1]=Cpo[j];
				Cpo[i]=item;
				this.ultimo++;
				bandera=true;
				}
			return bandera;
		}


		
		public boolean existeIte(Composicion item) {
			// TODO Auto-generated method stub
			boolean existe=false;
			for(int i=0;i<=this.ultimo;i++)
				if(item.compareTo(Cpo[i])==0) {
					existe=true;
					break;
				}
			return existe;
		}

		
		public Composicion getItem(int pos) {
			// TODO Auto-generated method stub
			Composicion m=null;
			if(!this.isFree()&& pos<=this.ultimo)
				m=Cpo[pos];
			return m;
		}

		
		public int getSize() {
			// TODO Auto-generated method stub
			return this.ultimo+1;
		}

		
		public boolean delete(Composicion item) {
			// TODO Auto-generated method stub
			boolean delete=false;
			if(this.existeIte(item)) {
				int i=0;
				for(;i<=this.ultimo;i++)
					if(item.compareTo(Cpo[i])==0)
						break;
				for(;i<this.ultimo;i++)
					Cpo[i]=Cpo[i+1];
				this.ultimo--;
				delete=true;
			}
			return delete;
		}

		
		public boolean isFree() {
			// TODO Auto-generated method stub
			return this.ultimo==-1;
		}

		
		public boolean isFull() {
			// TODO Auto-generated method stub
			return this.ultimo+1==this.Cpo.length;
		}
		public int getUltimo() {
			return ultimo;
		}
		public void setUltimo(int ultimo) {
			this.ultimo = ultimo;
		}
		public int getINC() {
			return INC;
		}
		
		public boolean existeItem(Composicion item) {
			
			return false;
		}
		
		public boolean clear(Composicion item) {
		
			return false;
		}
	}
