/** 
Obs.: Função Lambda está sendo atribuída a uma variável chamada NavBar.
const DataTable = () => {} ao invés de function NavBar() {},
porém, as duas formas estão corretas.
*/

/**
Verificar página Apex Charts React
https://apexcharts.com/docs/react-charts/
*/

import Chart from 'react-apexcharts';

const BarChart = () => {

    const options = {
        plotOptions: {
            bar: {
                horizontal: true,
            }
        },
    };

    const mockData = {
        labels: {
            categories: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
        },
        series: [
            {
                name: "% Sucesso",
                data: [43.6, 67.1, 67.7, 45.6, 71.1]
            }
        ]
    };

    return (
        <Chart 
            /** Referenciando a variável const options acima */
            /** 2 parênteses {{...options, conteúdo adicional na variável options}} */
            options={{...options, xaxis: mockData.labels}} 
            series={mockData.series}
            type="bar"
            height="240"

        />
    );
}

export default BarChart;