const tag = '[ExModel]'

export default {
    getExById(exId){
        console.log(tag, 'search(exId)', exId)
        return fetch('/api/ex/'+exId,{
            method : 'GET',
        }).then(response =>
            response.json().then(data => ({ status : response.status, data : data}))
        ).catch(err => {
            response.json().then(data => ({ data : data}))
        })
    },


    getExList(page){
      return fetch('/api/ex?page='+page,{
          method : 'GET',
      }).then(response =>
          response.json().then(data => ({ status : response.status, data : data}))
      ).catch(err => {
          response.json().then(data => ({ data : data}))
      })
    },

    insertEx(standardCode){
        const exJson = {'standardCode' : standardCode}
        return fetch('/api/ex',{
            method : 'POST',
            headers :{
                'Content-Type' : 'application/json'
            },
            body : JSON.stringify(exJson)
        }).then(response =>
            response.json().then(data => ({ status : response.status, data : data}))
        ).catch(err => {
            err.json().then(data => ({ data : data}))
        })
    },

}