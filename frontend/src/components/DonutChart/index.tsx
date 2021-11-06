/** 
Obs.: Função Lambda está sendo atribuída a uma variável chamada NavBar.
const DataTable = () => {} ao invés de function NavBar() {},
porém, as duas formas estão corretas.
*/

/**
Verificar página Apex Charts React
https://apexcharts.com/docs/react-charts/
*/

import axios from 'axios';
import { useEffect, useState } from 'react';
import Chart from 'react-apexcharts';
import { SaleSum } from 'types/sale';
import { BASE_URL } from 'utils/requests';

type ChartData = {
    labels: string[];
    series: number[];
}

const DonutChart = () => {

    /*FORMA ERRADA
    let chartData: ChartData = { labels: [], series: [] }; */

    //FORMA CERTA
    const [chartData, setChartData] = useState<ChartData>({ labels: [], series: [] });

    useEffect(() => {
        //tbm pode ser: axios.get(BASE_URL + '/sales/amount-by-seller')
        axios.get(`${BASE_URL}/sales/amount-by-seller`).then(
            response => {
                const data = response.data as SaleSum[];
                const myLabels = data.map(x => x.sellerName);
                const mySeries = data.map(x => x.sum);

                setChartData({ labels: myLabels, series: mySeries });
                //console.log(chartData);
            });
    }, []);

    // const mockData = {
    //   series: [477138, 499928, 444867, 220426, 473088],
    //   labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
    // }

    const options = {
        legend: {
            show: true
        }
    }

    return (
        <Chart
            /** Referenciando a variável const options acima */
            /** 2 parênteses {{...options, conteúdo adicional na variável options}} */
            options={{ ...options, labels: chartData.labels }}
            series={chartData.series}
            type="donut"
            height="240"

        />
    );
}

export default DonutChart;