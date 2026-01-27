import React from 'react'


const ListEmployeeComponent = () => {
    const dummyData = [
        {
            "id" : 1, 
            "firstName" : "Parth", 
            "lastName" : "Nilkanth",
            "email" : "parth@gmail.com"
            
        },
        {
            "id" : 2, 
            "firstName" : "Namrata", 
            "lastName" : "Nilkanth",
            "email" : "namrata@gmail.com"
            
        },
        {
            "id" : 3, 
            "firstName" : "Tejas", 
            "lastName" : "Nilkanth",
            "email" : "tejas@gmail.com"
            
        }
    ]


  return (

    <div className='container'>
        <h2 className='text-center'>List of Employees </h2>
        <table className='table table-striped table-bordered'>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email id </th>

                </tr>
            </thead>
            <tbody>
                {
                    dummyData.map(employee =>
                        <tr key = {employee.id}>
                            <td> {employee.id}</td>
                            <td>{employee.firstName}</td>
                            <td>{employee.lastName}</td>
                            <td>{employee.email}</td>
                        </tr>
                    )
                }
            </tbody>
        </table>
    </div>
  )
}

export default ListEmployeeComponent