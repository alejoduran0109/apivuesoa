import axios from 'axios'
axios.defaults.headers.common['Access-Control-Allow-Origin'] = '';
axios.defaults.headers.common['Access-Control-Allow-Methods'] = ''  
export const http = axios.create({
    baseURL: 'http://localhost:8002/tienda/',
});

export const http2 = axios.create({
    baseURL: 'http://localhost:8011/fabrica/',
});