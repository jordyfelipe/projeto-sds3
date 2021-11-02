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

const DonutChart = () => {

    const mockData = {
        series: [477138, 499928, 444867, 220426, 473088],
        labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
    }
    
    const options = {
        legend: {
            show: true
        }
    }

    return (
        <Chart 
            /** Referenciando a variável const options acima */
            /** 2 parênteses {{...options, conteúdo adicional na variável options}} */
            options={{...options, labels: mockData.labels}} 
            series={mockData.series}
            type="donut"
            height="240"

        />
    );
}

export default DonutChart;