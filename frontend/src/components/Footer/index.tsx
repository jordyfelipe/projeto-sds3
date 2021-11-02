/*Orientado pelo instrutor a fazer como variável
ou seja, é uma função Lambda (que não tem nome) e está 
sendo atribuída a uma variável chamada NavBar.
const DataTable = () => {} ao invés de function NavBar() {},
porém, os dois estão corretos.*/

const Footer = () => {
    return (
        <footer className="footer mt-auto py-3 bg-dark">
            <div className="container">
                <p className="text-light">App desenvolvido por <a href="https://github.com/jordyfelipe" target="_blank" rel="noreferrer">Jordy Felipe da Silva</a></p>
                <p className="text-light"><small><strong>Semana Spring React</strong><br />
                    Evento promovido pela escola DevSuperior: <a href="https://instagram.com/devsuperior.ig" target="_blank" rel="noreferrer">@devsuperior.ig</a></small></p>
            </div>
        </footer>
    );
}

export default Footer;