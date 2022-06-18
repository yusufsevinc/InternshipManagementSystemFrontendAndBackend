import axios from 'axios';
import SuccessResult from "@/assets/succus.result";

export function get(path = '') {
    return axios.get(path,{
        headers: {
                'Authorization': localStorage.getItem("token")
            }
        }
        ).catch(err => {
        console.log(err);
        throw new Error('Http Get Error : api.service');
    })

}

export function post(path = '', params,successMessage,errorMessage ,messageShow) {
    return axios.post(path, params,{
        headers: {
            'Authorization': localStorage.getItem("token")
        }
    })
        .then(response =>{
            if (messageShow){
                SuccessResult.methods.alertSuccess(successMessage);
                return response.data;
            }else{
                return response.data;
            }
        }).catch(err => {
            if (messageShow){
                console.log(err);
                SuccessResult.methods.alertError(errorMessage);
                return null;
            }else {
                return null;
            }
    })
}
