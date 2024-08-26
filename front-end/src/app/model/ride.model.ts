/**
 * Bike rides API
 * Bike rides API for managing bike rides
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


export interface Ride { 
    id?: number;
    modelId?: number;
    startedAt: string;
    endedAt?: string;
    distance?: number;
    own?: boolean;
    comment?: string;
    rating?: number;
}

