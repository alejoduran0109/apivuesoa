import { http, http2 } from './config'


export default	{

  listar:()=>{
		return http.get('all')
  },
  salvar:(fabrica_producto)=>{
		return http.post('insert',fabrica_producto);
  },
    
	atualizar:(fabrica_producto)=>{
		return http.put('update',fabrica_producto);
  },
  apagar:(fabrica_producto)=>{
    return http.delete("/delete/" + fabrica_producto)
    
  },
  
  despachar:(fabrica_producto)=>{
    return http2.post('insert', fabrica_producto);
  }
    

}