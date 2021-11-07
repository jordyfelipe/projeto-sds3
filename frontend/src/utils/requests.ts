//export const BASE_URL = 'http://localhost:8080';

//pegar variável de ambiente no Netlify:
export const BASE_URL = process.env.REACT_APP_BACKEND_URL ?? 'http://localhost:8080';

