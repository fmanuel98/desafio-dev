import http from "../services/HttpConfig";

async function uploadService(file: File) {
  const formData = new FormData();
  formData.append("file", file);
  return await http.post("/cnab", formData, {
    headers: {
      "Content-Type": "multipart/form-data",
    },
  });
}
export default uploadService;
