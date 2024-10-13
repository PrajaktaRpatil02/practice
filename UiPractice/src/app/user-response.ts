

export interface UserResponse {
        message: string;
        data: Data;
      }
      export interface Data {
        id: number;
        userName: string;
        password: string;
        emailId: string;
        craetedAt: string;
        updatedAt: string;
      }

      export interface Addressresponse {
        message: string;
        data: Address[];
      }
      export interface Address {
        id: number;
        addressLine: string;
        city: string;
        pincode: string;
        createdAt: string;
        updatedAt: string;
      }



      export interface UpdateAddressResponse {
        message: string;
        data: Data;
      }
    
      export interface User {
        id: number;
        userName: string;
        password: string;
        emailId: string;
        craetedAt: string;
        updatedAt: string;
      }


      export interface BookResponse {
        message: string;
        data: Book[];
      }
      export interface Book {
        id: number;
        title: string;
        author: string;
        genre: string;
        rating: number;
        price: number;
      }

      export interface UpdateBookResponse{
        message: string;
        data: Book;
      }

