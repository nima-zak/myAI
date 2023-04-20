import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Line } from 'react-chartjs-2';

function Analytics() {
  const [analyticsData, setAnalyticsData] = useState([]);

  useEffect(() => {
    axios.get('/api/analytics').then((res) => {
      setAnalyticsData(res.data);
    }).catch(console.error);
  }, []);

  const data = {
    labels: analyticsData.map((data) => data.date),
    datasets: [
      {
        label: 'Average Sentiment Score',
        data: analyticsData.map((data) => data.averageSentimentScore),
        fill: false,
        borderColor: 'rgb(75, 192, 192)',
        tension: 0.1,
      },
    ],
  };

  const options = {
    scales: {
      yAxes: [
        {
          ticks: {
            beginAtZero: true,
          },
        },
      ],
    },
  };

  return (
    <div>
      <h2>Analytics</h2>
      <Line data={data} options={options} />
    </div>
  );
}

export default Analytics;
