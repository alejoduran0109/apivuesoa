import { http, http2 } from './config'


export default	{

  listar:()=>{
		return http.get('all')
  },
  salvar:(producto_bodega)=>{
		return http.post('insert',producto_bodega);
  },
    
	atualizar:(producto_bodega)=>{
		return http.put('update',producto_bodega);
  },
  apagar:(producto_bodega)=>{
    return http.delete("/delete/" + producto_bodega)
    
  },
  
  despachar:(producto_bodega)=>{
    return http2.post('insert', producto_bodega);
  }
    

}