import {get} from "@/services/api.service";
import {BASE_URL} from "@/services/config";

export function getNeighborhoodDistrictAll(id) {
    return get(BASE_URL + 'neighborhood/neighborhood-district/' + id);
}
