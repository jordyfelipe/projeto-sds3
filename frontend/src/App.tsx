import DataTable from "components/DataTable";
import Footer from "components/Footer";
import NavBar from "components/NavBar";

function App() {
  /* Utilizado (fragment <> </>) no início e fim do retorno para que 
  seja delimitado como um elemento só, pois o retorno da função no React 
  pode ter apenas 1 elemento.*/
  return (
    <>
      <NavBar />
      <div className="container">
        <h1 className="text-primary">Olá mundo!</h1>
        <DataTable />
      </div>
      <Footer />
    </>
  );
}

export default App;
