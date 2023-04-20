import axios from 'axios';

const authHeader = {
    headers: {
      Authorization: 'Basic ' + btoa('Admin:Admin1188'),
    },
  };

export const fetchData = async (endpoint) => {
  try {
    const response = await axios.get(`http://localhost:8080/api/${endpoint}`, authHeader);
    return response.data;
  } catch (error) {
    console.error('Error fetching data:', error.message);
    throw error;
  }
};
