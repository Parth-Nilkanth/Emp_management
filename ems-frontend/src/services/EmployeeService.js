import axios from "axios";
const REST_API_BASE_URL = "http://localhost:8080/api/employees";
export const listEmployees = () => {
    return axios.get(REST_API_BASE_URL);
}

export const createEmployee = (employee) => axios.post(REST_API_BASE_URL,employee)

export const getEmployee = (employeeId) => axios.get(REST_API_BASE_URL+'/'+employeeId)

// to send data to update employee rest api (backend0)
export const updateEmployee = (employeeId, employee) => axios.put(REST_API_BASE_URL +'/'+employeeId , employee)

// for delete employee
export const deleteEmployee = (employeeId) =>  axios.delete(REST_API_BASE_URL + '/' + employeeId)