import {get} from "@/services/api.service";
import {BASE_URL} from "@/services/config";

export function districtAll() {
    return get(BASE_URL + 'district/all');
}

export function getAllCityDistrict(id) {
    return get(BASE_URL + 'district/district-city/'+id);
}
