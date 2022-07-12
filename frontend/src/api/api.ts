import axios from 'axios'

export default () => {
  return createApi()
}

export function createApi () {
  const api = axios.create({
    // baseURL: 'localhost:8087',
    withCredentials: false,
    headers: {
      Accept: 'application/json',
      'Content-Type': 'application/json'
    }
  })
  // if (store.state.restPasswordEnabled === true && store.state.restAuthType === 'Basic') {
  //   var hash = btoa(store.state.restUsername + ":" +store.state.restPassword)
  //   api.defaults.headers.common['Authorization'] = hash;
  // }
  // if (store.state.restPasswordEnabled == true && store.state.restAuthType == "Bearer") {
  //   api.defaults.headers.common['Authorization'] = "Bearer " + store.state.restBearerToken;
  // }
  return api
}

export async function get (rootEntity: string, params: object | null) {
  return new Promise(function (resolve, reject) {
    if (rootEntity == null) {
      return 'no rootEntity!'
    }
    createApi()
      .get(rootEntity, { params })
      .then(response => {
        let entity = ''
        entity = response.data
        resolve(entity)
      })
      .catch(error => {
        reject(error)
      })
  })
}

export async function post (rootEntity: string, params: object | null, data: any) {
  return new Promise(function (resolve, reject) {
    if (rootEntity == null) {
      return 'no rootEntity!'
    }
    createApi()
      .post(rootEntity, data, { params })
      .then(response => {
        let entity = ''
        entity = response.data
        resolve(entity)
      })
      .catch(error => {
        reject(error)
      })
  })
}
