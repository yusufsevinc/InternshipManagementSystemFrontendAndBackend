import {get, post} from "@/services/api.service";
import {BASE_URL} from "@/services/config";


export function companyAll() {
    return get(BASE_URL + 'company/all');
}

export function saveCompany(data) {
    return post(BASE_URL+'company/id-with-save',data,
        "Company information has been successfully saved.",
        "Company information could not be successfully saved!",
        true);
}
