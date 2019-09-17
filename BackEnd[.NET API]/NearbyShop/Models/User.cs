using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace NearbyShop.Models
{
    public class User
    {
        public Guid Id { get; set; }
        [Required]
        public string name { get; set; }
        public string username { get; set; }
        [Required]
        public string password { get; set; }
        public virtual ICollection<UserShop> shops { get; set; }

       
    }
}
