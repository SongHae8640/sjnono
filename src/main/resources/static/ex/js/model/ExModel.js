const tag = '[ExModel]'

export default {
    getExById(exId){
        console.log(tag, 'search(exId)', exId)
        return fetch('/api/ex/'+exId,{
            method : 'GET',
        })
        // .then(response => {
        //     console.log(tag, 'search() Promise response', response)
        //     return response.json()
        // })
        // .then(jsonData =>{
        //     console.log(tag, 'search() jsonData', jsonData)
        //     return jsonData
        // })
        // .catch(err =>{
        //     console.log(tag, 'search() err', err)
        //     return err
        // })
    },
    getExList(page){
      return fetch('/api/ex?page='+page,{
          method : 'GET',
      })
    },

    insertEx(standardCode){
        var exJson = {stock : {'standardCode' : standardCode}}
        return fetch('/api/ex',{
            method : 'POST',
            headers :{
                'Content-Type' : 'application/json'
            },
            body : JSON.stringify(exJson)
        })
    },

}