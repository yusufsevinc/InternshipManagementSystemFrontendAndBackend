import {get, post} from "@/services/api.service";
import {BASE_URL} from "@/services/config";

export function companyExecutiveAll() {
    return get(BASE_URL + 'company-executive/all');
}

export function getCompanyExecutiveDetailById(id) {
    return get(BASE_URL + 'company-executive/detail/' + id);
}

export function saveCompanyExecutive(data) {
    return post(BASE_URL+'company-executive/id-with-save',data,
        "Company Executive information has been successfully saved.",
        "Company Executive information could not be successfully saved!",
        true);
}
